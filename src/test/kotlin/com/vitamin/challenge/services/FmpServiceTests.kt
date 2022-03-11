package com.vitamin.challenge.services

import com.vitamin.challenge.config.FmpProperties
import com.vitamin.challenge.model.HistoricalPriceFull
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.util.retry.Retry
import java.time.Duration
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class FmpServiceTests(private val fmpProperties: FmpProperties, private val webClient: WebClient) {
    @Test
    fun `date is properly formatted for endpoint call`(){
        //TODO: Given, When, Then
    }

    @Test
    fun `calls the correct endpoint for historical stock price`(){
        //TODO: Given, When, Then
    }
}