package com.vitamin.challenge.repositories

import com.vitamin.challenge.model.PortfolioRiskTolerance
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.util.*

interface PortfolioRepository : MongoRepository<PortfolioRiskTolerance, String> {
    @Query("{ '\$and': [ { 'riskToleranceLowerBound': { '\$lte': ?0 } }, { 'riskToleranceUpperBound': { '\$gte': ?0 } } ] }")
    fun findByRiskLevel(riskLevel: Int): Optional<PortfolioRiskTolerance>
}