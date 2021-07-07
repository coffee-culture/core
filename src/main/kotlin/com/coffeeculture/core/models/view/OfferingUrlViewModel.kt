package com.coffeeculture.core.models.view

import com.coffeeculture.core.models.event.OfferingUrlType
import java.net.URL

data class OfferingUrlViewModel(
    val type: OfferingUrlType,
    val value: URL
)
