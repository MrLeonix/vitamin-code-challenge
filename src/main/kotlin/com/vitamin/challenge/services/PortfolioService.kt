package com.vitamin.challenge.services

import com.vitamin.challenge.exceptions.NoPortfolioFoundForRiskLevelException
import com.vitamin.challenge.model.PortfolioRiskTolerance
import com.vitamin.challenge.repositories.PortfolioRepository
import org.springframework.stereotype.Service

@Service
class PortfolioService(private val portfolioRepository: PortfolioRepository) {
    fun getMatchingPortfolio(riskLevel: Int): PortfolioRiskTolerance {
        return portfolioRepository.findByRiskLevel(riskLevel).orElseThrow { NoPortfolioFoundForRiskLevelException() }
    }
}