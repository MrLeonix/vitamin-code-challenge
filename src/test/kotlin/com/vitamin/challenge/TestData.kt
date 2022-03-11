package com.vitamin.challenge

import com.vitamin.challenge.model.HistoricalPrice
import com.vitamin.challenge.model.HistoricalPriceFull
import com.vitamin.challenge.model.Portfolio
import com.vitamin.challenge.model.PortfolioRiskTolerance
import java.math.BigDecimal
import java.math.BigInteger
import java.time.LocalDate

val fromDate = LocalDate.of(2017, 1, 1)
val toDate = LocalDate.of(2022, 6, 3)

val testABCHistoricalPrices = HistoricalPriceFull(
    "ABC", listOf(
        HistoricalPrice(
            "2021-06-03",
            BigDecimal.valueOf(58.57),
            BigDecimal.valueOf(59.17),
            BigDecimal.valueOf(57.1),
            BigDecimal.valueOf(58.16),
            BigDecimal.valueOf(58.16),
            BigInteger.valueOf(2025021),
            BigInteger.valueOf(2025021),
            BigDecimal.valueOf(-0.41),
            BigDecimal.valueOf(-0.7),
            BigDecimal.valueOf(58.14333),
            "June 02, 21",
            BigDecimal.valueOf(-0.007)
        ),
        HistoricalPrice(
            "2021-06-02",
            BigDecimal.valueOf(58.57),
            BigDecimal.valueOf(59.17),
            BigDecimal.valueOf(57.1),
            BigDecimal.valueOf(58.16),
            BigDecimal.valueOf(58.16),
            BigInteger.valueOf(2025021),
            BigInteger.valueOf(2025021),
            BigDecimal.valueOf(-0.41),
            BigDecimal.valueOf(-0.7),
            BigDecimal.valueOf(58.14333),
            "June 02, 21",
            BigDecimal.valueOf(-0.007)
        ),
        HistoricalPrice(
            "2021-06-01",
            BigDecimal.valueOf(58.57),
            BigDecimal.valueOf(59.17),
            BigDecimal.valueOf(57.1),
            BigDecimal.valueOf(58.16),
            BigDecimal.valueOf(58.16),
            BigInteger.valueOf(2025021),
            BigInteger.valueOf(2025021),
            BigDecimal.valueOf(-0.41),
            BigDecimal.valueOf(-0.7),
            BigDecimal.valueOf(58.14333),
            "June 02, 21",
            BigDecimal.valueOf(-0.007)
        ),
        HistoricalPrice(
            "2021-05-25",
            BigDecimal.valueOf(58.57),
            BigDecimal.valueOf(59.17),
            BigDecimal.valueOf(57.1),
            BigDecimal.valueOf(58.16),
            BigDecimal.valueOf(58.16),
            BigInteger.valueOf(2025021),
            BigInteger.valueOf(2025021),
            BigDecimal.valueOf(-0.41),
            BigDecimal.valueOf(-0.7),
            BigDecimal.valueOf(58.14333),
            "June 02, 21",
            BigDecimal.valueOf(-0.007)
        ),
        HistoricalPrice(
            "2021-06-15",
            BigDecimal.valueOf(58.57),
            BigDecimal.valueOf(59.17),
            BigDecimal.valueOf(57.1),
            BigDecimal.valueOf(58.16),
            BigDecimal.valueOf(58.16),
            BigInteger.valueOf(2025021),
            BigInteger.valueOf(2025021),
            BigDecimal.valueOf(-0.41),
            BigDecimal.valueOf(-0.7),
            BigDecimal.valueOf(58.14333),
            "June 02, 21",
            BigDecimal.valueOf(-0.007)
        ),
        HistoricalPrice(
            "2021-06-02",
            BigDecimal.valueOf(58.57),
            BigDecimal.valueOf(59.17),
            BigDecimal.valueOf(57.1),
            BigDecimal.valueOf(58.16),
            BigDecimal.valueOf(58.16),
            BigInteger.valueOf(2025021),
            BigInteger.valueOf(2025021),
            BigDecimal.valueOf(-0.41),
            BigDecimal.valueOf(-0.7),
            BigDecimal.valueOf(58.14333),
            "June 02, 21",
            BigDecimal.valueOf(-0.007)
        )
    )
)

val testPortfolioRiskToleranceLevel1 = PortfolioRiskTolerance(
    1,
    2,
    listOf(
        Portfolio(0.2, "ABC"),
        Portfolio(0.3, "XYZ"),
        Portfolio(0.5, "LLL")
    )
)

val testPortfolioRiskToleranceLevel3 = PortfolioRiskTolerance(
    3,
    4,
    listOf(
        Portfolio(0.4, "ABC"),
        Portfolio(0.2, "XYZ"),
        Portfolio(0.4, "LLL")
    )
)

val testPortfolioRiskToleranceLevel5 =
    PortfolioRiskTolerance(
        5,
        8,
        listOf(
            Portfolio(0.6, "ABC"),
            Portfolio(0.15, "XYZ"),
            Portfolio(0.25, "LLL")
        )
    )

val dummyPortfolios = listOf(
    testPortfolioRiskToleranceLevel1,
    testPortfolioRiskToleranceLevel3,
    testPortfolioRiskToleranceLevel5

)