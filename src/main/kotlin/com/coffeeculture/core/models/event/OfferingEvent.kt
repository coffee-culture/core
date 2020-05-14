package com.coffeeculture.core.models.event

import java.time.Instant

data class OfferingEvent(
    val name: String,
    val description: String,

    /*
        Not sure on the delineation between `name` and `origin`.

        The concept of `origin` would better capture the inconsistent data across different roasters
        and origins. The inconsistent nature of this makes it difficult to model.

        This could ultimately be modeled as an object that contains specific origin properties, such
        as `country`, `region`, etc, and a Map for additional details.
     */
    val origin: Map<String, String>,

    val quantityPrice: List<QuantityPrice>,
    val roaster: Roaster,

    val tastingNotes: List<String>,
    val urls: List<OfferingUrl>,

    /*
        This will be a JSON String used to store additional details that will vary across
        Roasters, Origins, etc.
     */
    val details: String,

    val processedAt: Instant
)
