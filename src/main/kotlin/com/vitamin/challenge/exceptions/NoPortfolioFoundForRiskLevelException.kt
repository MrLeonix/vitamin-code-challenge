package com.vitamin.challenge.exceptions

class NoPortfolioFoundForRiskLevelException(override val message: String = "No portfolio was found for the provided risk level."): Exception(message)