package com.coffeeculture.core.models.event

import java.math.BigDecimal
import java.util.Currency
import java.util.Locale

data class Price(
    val value: BigDecimal,
    val currency: Currency = Currency.getInstance(Locale.US)
)
