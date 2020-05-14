package com.coffeeculture.core.transformers

import com.coffeeculture.core.models.event.OfferingEvent
import com.coffeeculture.core.models.event.OfferingUrl
import com.coffeeculture.core.models.event.OfferingUrlType
import com.coffeeculture.core.models.view.OfferingUrlViewModel
import com.coffeeculture.core.models.view.OfferingsViewModel
import org.springframework.stereotype.Component

interface OfferingViewModelToEventTransformer :
    Transformer<List<OfferingEvent>, OfferingsViewModel>

@Component
class OfferingViewModelToEventTransformerImpl(
    private val toQuantityPriceTransformer: QuantityPriceViewModelToEventTransformer,
    private val toRoasterEventTransformer: RoasterViewModelToEventTransformer
) : OfferingViewModelToEventTransformer {
    override fun transform(source: OfferingsViewModel): List<OfferingEvent> {
        val roaster = toRoasterEventTransformer.transform(source.roaster)

        return source.offerings.map {
            OfferingEvent(
                name = it.name,
                description = it.description,
                details = it.details,
                origin = it.origin,
                quantityPrice = it.quantityPrice.map { qpvm ->
                    toQuantityPriceTransformer.transform(qpvm)
                },
                tastingNotes = it.tastingNotes,
                roaster = roaster,

                // Not sure Event/ViewModel separation is necessary, but I don't know about 
                // mixing components.
                urls = transformUrls(it.urls),
                processedAt = it.processedAt
            )
        }
    }

    // This should probably live elsewhere
    private fun transformUrls(urls: List<OfferingUrlViewModel>): List<OfferingUrl> {
        return urls.map {
            OfferingUrl(
                type = OfferingUrlType.valueOf(it.type.toString()),
                value = it.value
            )
        }
    }
}
