package com.coffeeculture.core.models

import java.time.Instant

data class Offering (
    val roaster: Roaster,

    /*
        Not sure that both origin and name are required.
        I think there may be value in storing both name and origin, since origin will not be consistent
        across roasters.
     */
    val name: String,

    /*
        Not sure that both origin and name are required.
        Some roasters will report much more detailed origin data than others, to the farm level. Some will
        report this using the name of the farm owners, while others will use a farm name.

        Origin could be implemented as an object that is the attempted breakdown of these details, while
        name represents the summary info.
     */
    val origin: String,

    val description: String,
    val tastingNotes: List<String> = emptyList(),
    val urls: List<OfferingUrl>,
    val price: String, // ?
    val details: String,    // this will hold the entire scraped details as json
    val processedAt: Instant
)