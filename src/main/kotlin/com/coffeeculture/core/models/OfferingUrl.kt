package com.coffeeculture.core.models

import java.net.URL

data class OfferingUrl(
    val type: OfferingUrlType,
    val value: URL
)