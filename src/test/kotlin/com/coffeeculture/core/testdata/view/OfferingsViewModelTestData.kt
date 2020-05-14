package com.coffeeculture.core.testdata.view

import com.coffeeculture.core.models.event.OfferingUrlType
import com.coffeeculture.core.models.view.OfferingUrlViewModel
import com.coffeeculture.core.models.view.OfferingViewModel
import com.coffeeculture.core.models.view.OfferingsViewModel
import com.coffeeculture.core.models.view.PriceViewModel
import com.coffeeculture.core.models.view.QuantityPriceTypeViewModel
import com.coffeeculture.core.models.view.QuantityPriceViewModel
import com.coffeeculture.core.models.view.QuantityViewModel
import com.coffeeculture.core.models.view.RoasterViewModel
import java.math.BigDecimal
import java.net.URL
import java.time.Instant

object OfferingsViewModelTestData {

    fun littleWolfOfferings(): OfferingsViewModel {
        return OfferingsViewModel(
            roaster = RoasterViewModel(
                id = "08fa6ef4-0c64-4635-8a9d-c4ac973c04dc",
                name = "Little Wolf Coffee"
            ),
            offerings = listOf(
                ethiopiaNanoGenjiLittleWolf()
            )
        )
    }

    fun ethiopiaNanoGenjiLittleWolf(): OfferingViewModel {
        return OfferingViewModel(
            name = "Ethiopia Nano Genji",
            urls = listOf(
                OfferingUrlViewModel(
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
                QuantityPriceViewModel(
                    quantity = QuantityViewModel(
                        value = 8.0,
                        unit = "oz"
                    ),
                    price = PriceViewModel(
                        value = BigDecimal.valueOf(13.00),
                        currencyCode = "USD"
                    ),
                    type = QuantityPriceTypeViewModel.PRIMARY
                )
            ),
            processedAt = Instant.parse("2020-05-10T15:12:41Z")
        )
    }
}
