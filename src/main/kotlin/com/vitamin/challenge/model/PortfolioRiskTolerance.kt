package com.vitamin.challenge.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PortfolioRiskTolerance(
    val riskToleranceLowerBound: Int,
    val riskToleranceUpperBound: Int,
    val portfolio: List<Portfolio>
)

data class Portfolio(
    val weight: Double,
    val ticker: String
)