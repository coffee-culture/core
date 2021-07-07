package com.coffeeculture.core.models.event

import java.net.URL

data class OfferingUrl(
    val type: OfferingUrlType,
    val value: URL
)

enum class OfferingUrlType {
    OFFERING,
    OFFERING_IMAGE
}
