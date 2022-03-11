package com.vitamin.challenge.portfolio

import com.vitamin.challenge.dto.CurrentValue
import com.vitamin.challenge.model.HistoricalPrice
import com.vitamin.challenge.model.HistoricalPriceFull
import com.vitamin.challenge.services.FmpService
import com.vitamin.challenge.services.PortfolioService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDate

@Component
class CurrentValueCalculator(val fmpService: FmpService, val portfolioService: PortfolioService) {
    val logger: Logger = LogManager.getLogger(CurrentValueCalculator::class.java)

    suspend fun calculateCurrentValue(
        riskLevel: Int,
        from: LocalDate,
        to: LocalDate,
        monthlyContribution: Double
    ): List<CurrentValue> {
        val portfolioRiskTolerance = portfolioService.getMatchingPortfolio(riskLevel)

        val currentValues: Map<String, CurrentValue> = portfolioRiskTolerance.portfolio.map {
            it.ticker to CurrentValue(it.ticker, BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.0))
        }.toMap()

        portfolioRiskTolerance.portfolio.forEach {
            val historicalStockPrice = fmpService.getHistoricalStockPrice(it.ticker, from, to)
            if (historicalStockPrice == null) {
                logger.warn("No historical stock price found for ${it.ticker}.")
                return@forEach
            }

            val monthlyHistoricalStockPrice = getMonthlyStockPrice(historicalStockPrice)
            monthlyHistoricalStockPrice.historical.forEach { price ->
                val bigMonthlyContribution = BigDecimal.valueOf(monthlyContribution)
                val bigWeight = BigDecimal.valueOf(it.weight)
                val investment = bigMonthlyContribution * bigWeight
                currentValues[it.ticker]!!.shares += investment / price.close
            }
            currentValues[it.ticker]!!.value =
                monthlyHistoricalStockPrice.historical.last().close * currentValues[it.ticker]!!.shares
        }

        return currentValues.values.toList()
    }

    private fun getMonthlyStockPrice(historicalPrice: HistoricalPriceFull): HistoricalPriceFull {
        val monthlyHistoricalPriceFullMap = emptyMap<String, HistoricalPrice>().toMutableMap()

        historicalPrice.historical.sortedBy { it.date }.forEach {
            val key = it.date.substring(0, 7)
            if (!monthlyHistoricalPriceFullMap.containsKey(key)) {
                monthlyHistoricalPriceFullMap[key] = it.copy()
            }
        }

        return HistoricalPriceFull(historicalPrice.symbol, monthlyHistoricalPriceFullMap.values.toList())
    }
}