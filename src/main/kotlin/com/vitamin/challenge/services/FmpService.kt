package com.vitamin.challenge.services

import com.vitamin.challenge.config.FmpProperties
import com.vitamin.challenge.model.HistoricalPriceFull
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.util.retry.Retry
import java.time.Duration
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class FmpService(private val fmpProperties: FmpProperties, private val webClient: WebClient) {
    private object Constants {
        const val FIXED_RETRY_DELAY = 100L
        const val MAX_RETRY_ATTEMPTS = 3L
    }

    val logger: Logger = org.apache.logging.log4j.LogManager.getLogger(FmpService::class.java)

    val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    suspend fun getHistoricalStockPrice(stock: String, from: LocalDate, to: LocalDate): HistoricalPriceFull? {
        val fromString = from.format(dateFormat)
        val toString = to.format(dateFormat)

        logger.info("Fetching values for $stock... from $fromString to $toString")

        return webClient().get().uri {
            it.path("/api/v3/historical-price-full/$stock")
            it.queryParam("from", fromString)
            it.queryParam("to", toString)
            it.queryParam("apikey", fmpProperties.apiKey)
                .build()
        }
            .retrieve()
            .bodyToMono(HistoricalPriceFull::class.java)
            .retryWhen(
                Retry.backoff(
                    Constants.MAX_RETRY_ATTEMPTS,
                    Duration.ofMillis(Constants.FIXED_RETRY_DELAY)
                )
            )
            .block()
    }

    private fun webClient() = webClient.mutate()
        .baseUrl(fmpProperties.apiHost)
        .build()
}