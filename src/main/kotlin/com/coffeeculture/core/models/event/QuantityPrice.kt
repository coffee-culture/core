package com.coffeeculture.core.models.event

data class QuantityPrice(
    val type: QuantityPriceType,
    val quantity: Quantity,
    val price: Price
)

enum class QuantityPriceType {
    PRIMARY,
    SECONDARY
}
