package com.coffeeculture.core.transformers

import com.coffeeculture.core.models.event.Price
import com.coffeeculture.core.models.event.Quantity
import com.coffeeculture.core.models.event.QuantityPrice
import com.coffeeculture.core.models.event.QuantityPriceType
import com.coffeeculture.core.models.view.QuantityPriceViewModel
import java.lang.IllegalArgumentException
import java.util.Currency
import java.util.Locale
import org.springframework.stereotype.Component

interface QuantityPriceViewModelToEventTransformer : Transformer<QuantityPrice, QuantityPriceViewModel>

@Component
class QuantityPriceViewModelToEventTransformerImpl : QuantityPriceViewModelToEventTransformer {
    override fun transform(source: QuantityPriceViewModel): QuantityPrice {
        // Default to US currency
        val usDollar = Currency.getInstance(Locale.US)

        // This is an oversimplification that will do for now
        return QuantityPrice(
            type = QuantityPriceType.valueOf(source.type.name),
            price = Price(
                value = source.price.value,

                // TODO: Attempt to only do this once per roaster
                // TODO: Use Roaster Locale to determine currency
                currency = when (source.price.currencyCode != null) {
                    true -> {
                        // Default currency to US dollar when currency code is invalid
                        try {
                            Currency.getInstance(source.price.currencyCode)
                        } catch (e: IllegalArgumentException) {
                            usDollar
                        }
                    }
                    false -> usDollar
                }
            ),
            quantity = Quantity(
                unit = source.quantity.unit,
                value = source.quantity.value
            )
        )
    }
}
