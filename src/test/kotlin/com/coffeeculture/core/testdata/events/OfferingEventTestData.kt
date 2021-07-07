package com.coffeeculture.core.testdata.events

import com.coffeeculture.core.models.event.OfferingEvent
import com.coffeeculture.core.models.event.OfferingUrl
import com.coffeeculture.core.models.event.OfferingUrlType
import com.coffeeculture.core.models.event.Price
import com.coffeeculture.core.models.event.Quantity
import com.coffeeculture.core.models.event.QuantityPrice
import com.coffeeculture.core.models.event.QuantityPriceType
import com.coffeeculture.core.models.event.Roaster
import java.math.BigDecimal
import java.net.URL
import java.time.Instant
import java.util.Currency
import java.util.Locale

object OfferingEventTestData {

    fun ethiopiaNanoGenjiLittleWolf(): OfferingEvent {
        return OfferingEvent(
            name = "Ethiopia Nano Genji",
            urls = listOf(
                OfferingUrl(
                    type = OfferingUrlType.OFFERING,
                    value = URL("https://littlewolf.coffee/collections/shop/products/nano-genji")
                )
            ),
            tastingNotes = listOf("sweet tea", "lime", "floral"),
            origin = mapOf(
                "raw" to "Ethiopia - Jimma, Agaro Gera",
                "country" to "Ethiopia",
                "farm" to "Nano Genji"
            ),
            description = "",
            details = "{\"Tasting Notes\":\"Sweet Tea, Lime, Floral\",\"Origin\":\"Ethiopia - Jimma, Agaro Gera\",\"Farm/Co-op\":\"Nano Genji\",\"Process\":\"Washed\",\"Elevation\":\"1900-2200m\",\"Varietal\":\"Ethiopia Landraces\",\"Sourced By\":\"Red Fox Coffee Merchants\"}",
            quantityPrice = listOf(
                QuantityPrice(
                    type = QuantityPriceType.PRIMARY,
                    quantity = Quantity(
                        unit = "oz",
                        value = 8.0
                    ),
                    price = Price(
                        value = BigDecimal.valueOf(13.00),
                        currency = Currency.getInstance(Locale.US)
                    )
                )
            ),
            roaster = Roaster(
                id = "08fa6ef4-0c64-4635-8a9d-c4ac973c04dc",
                name = "Little Wolf Coffee"
            ),
            processedAt = Instant.parse("2020-05-10T15:12:41Z")
        )
    }
}
