package com.vitamin.challenge.web.controller

import com.vitamin.challenge.dto.CurrentValue
import com.vitamin.challenge.model.Portfolio
import com.vitamin.challenge.portfolio.CurrentValueCalculator
import com.vitamin.challenge.portfolio.PortfolioMatcher
import com.vitamin.challenge.validators.InvestmentPortfolioValidator
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("users")
class UserController(val currentValueCalculator: CurrentValueCalculator, val portfolioMatcher: PortfolioMatcher) {
    @PostMapping("me/investment-portfolio")
    fun investmentPortfolio(@RequestParam("riskLevel") riskLevel: Int): List<Portfolio> {
        return portfolioMatcher.retrievePortfolioBasedOnRiskLevel(riskLevel)
    }

    @PostMapping("me/investment-portfolio/current-value")
    suspend fun investmentPortfolioCurrentValue(
        @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") from: LocalDate,
        @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") to: LocalDate,
        @RequestParam("monthlyContribution") monthlyContribution: Double,
        @RequestParam("riskLevel") riskLevel: Int
    ): List<CurrentValue> {
        InvestmentPortfolioValidator.validateCurrentValueParameters(from, to, monthlyContribution)
        return currentValueCalculator.calculateCurrentValue(
            riskLevel,
            from, to,
            monthlyContribution
        )
    }
}