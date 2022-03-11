package com.vitamin.challenge.dto

import java.math.BigDecimal

data class CurrentValue(
    val ticker: String,
    var value: BigDecimal,
    var shares: BigDecimal,
)