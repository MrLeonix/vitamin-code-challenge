package com.vitamin.challenge.validators

import com.vitamin.challenge.exceptions.InvalidDateException
import com.vitamin.challenge.exceptions.NegativeOrZeroMonthlyContributionException
import java.time.LocalDate

class InvestmentPortfolioValidator {
    companion object {
        fun validateCurrentValueParameters(
            from: LocalDate,
            to: LocalDate,
            monthlyContribution: Double
        ) {
            if (from.isAfter(to)) throw InvalidDateException()
            if (monthlyContribution <= 0.0) throw NegativeOrZeroMonthlyContributionException()
        }
    }
}