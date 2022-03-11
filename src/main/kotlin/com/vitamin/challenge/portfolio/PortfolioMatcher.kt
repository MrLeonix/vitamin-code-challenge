package com.vitamin.challenge.portfolio

import com.vitamin.challenge.model.Portfolio
import com.vitamin.challenge.services.PortfolioService
import org.springframework.stereotype.Component

@Component
class PortfolioMatcher(private val portfolioService: PortfolioService) {
    fun retrievePortfolioBasedOnRiskLevel(riskLevel: Int): List<Portfolio> {
        val matchingPortfolio = portfolioService.getMatchingPortfolio(riskLevel)
        return matchingPortfolio.portfolio
    }
}