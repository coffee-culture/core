package com.coffeeculture.core.models.view

import java.math.BigDecimal

data class PriceViewModel(
    val value: BigDecimal,
    val currencyCode: String? = null
)
