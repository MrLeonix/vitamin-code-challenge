package com.vitamin.challenge.services

import com.vitamin.challenge.repositories.PortfolioRepository
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Service

@Service
class PortfolioServiceTests(private val portfolioRepository: PortfolioRepository) {
    @Test
    fun `retrieved portfolio matches risk level`() {
        //TODO: Given, When, Then
    }

    @Test
    fun `throws NoPortfolioFoundForRiskLevelException when no portfolio is found`() {
        //TODO: Given, When, Then
    }
}