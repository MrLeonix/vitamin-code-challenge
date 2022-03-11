package com.vitamin.challenge.exceptions

class NegativeOrZeroMonthlyContributionException(override val message: String = "'monthlyContribution' must be higher than 0.") :
    Exception(message)