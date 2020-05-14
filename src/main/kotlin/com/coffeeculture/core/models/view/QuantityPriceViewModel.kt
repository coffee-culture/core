package com.coffeeculture.core.models.view

data class QuantityPriceViewModel(
    val price: PriceViewModel,
    val quantity: QuantityViewModel,
    val type: QuantityPriceTypeViewModel
)

enum class QuantityPriceTypeViewModel {
    PRIMARY,
    SECONDARY
}
