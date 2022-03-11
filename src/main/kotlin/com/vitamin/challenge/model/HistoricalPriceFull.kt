package com.vitamin.challenge.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
import java.math.BigInteger

@JsonIgnoreProperties(ignoreUnknown = true)
data class HistoricalPriceFull(
    val symbol: String = "",
    val historical: List<HistoricalPrice> = emptyList()
)

data class HistoricalPrice(
    val date: String,
    val open: BigDecimal,
    val high: BigDecimal,
    val low: BigDecimal,
    val close: BigDecimal,
    val adjClose: BigDecimal,
    val volume: BigInteger,
    val unadjustedVolume: BigInteger,
    val change: BigDecimal,
    val changePercent: BigDecimal,
    val vwap: BigDecimal,
    val label: String,
    val changeOverTime: BigDecimal,
)
