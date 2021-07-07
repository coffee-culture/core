package com.coffeeculture.core.models.view

import java.time.Instant

/*
    For specific details on the guts of this model as it evolves, please see the
    [com.coffeeculture.core.models.event.Offering] event model. Changes will be
    propagated here and documented as the model is solidified.
 */
data class OfferingViewModel(
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

    val quantityPrice: List<QuantityPriceViewModel>,

    val tastingNotes: List<String>,
    val urls: List<OfferingUrlViewModel>,

    val details: String,

    val processedAt: Instant
)
