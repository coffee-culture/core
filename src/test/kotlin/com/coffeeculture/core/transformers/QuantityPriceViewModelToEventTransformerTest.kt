package com.coffeeculture.core.transformers

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.coffeeculture.core.models.event.Price
import com.coffeeculture.core.models.event.Quantity
import com.coffeeculture.core.models.event.QuantityPrice
import com.coffeeculture.core.models.event.QuantityPriceType
import com.coffeeculture.core.models.view.PriceViewModel
import com.coffeeculture.core.models.view.QuantityPriceTypeViewModel
import com.coffeeculture.core.models.view.QuantityPriceViewModel
import com.coffeeculture.core.models.view.QuantityViewModel
import java.math.BigDecimal
import java.util.Currency
import java.util.Locale
import org.junit.jupiter.api.Test

class QuantityPriceViewModelToEventTransformerTest {
    private val transformer = QuantityPriceViewModelToEventTransformerImpl()

    @Test
    fun `transforms USD QuantityPriceViewModel to QuantityPrice event instance`() {
        val viewModel = QuantityPriceViewModel(
            type = QuantityPriceTypeViewModel.PRIMARY,
            price = PriceViewModel(
                value = BigDecimal.valueOf(13.00),
                currencyCode = Currency.getInstance(Locale.US).currencyCode
            ),
            quantity = QuantityViewModel(
                value = 8.0,
                unit = "oz"
            )
        )

        val expected = QuantityPrice(
            type = QuantityPriceType.PRIMARY,
            price = Price(
                value = BigDecimal.valueOf(13.00),
                currency = Currency.getInstance(Locale.US)
            ),
            quantity = Quantity(
                value = 8.0,
                unit = "oz"
            )
        )

        val result = transformer.transform(viewModel)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `transforms non-USD QuantityPriceViewModel to QuantityPrice event instance`() {
        val viewModel = QuantityPriceViewModel(
            type = QuantityPriceTypeViewModel.PRIMARY,
            price = PriceViewModel(
                value = BigDecimal.valueOf(13.00),
                currencyCode = Currency.getInstance(Locale.CANADA).currencyCode
            ),
            quantity = QuantityViewModel(
                value = 8.0,
                unit = "oz"
            )
        )

        val expected = QuantityPrice(
            type = QuantityPriceType.PRIMARY,
            price = Price(
                value = BigDecimal.valueOf(13.00),
                currency = Currency.getInstance(Locale.CANADA)
            ),
            quantity = Quantity(
                value = 8.0,
                unit = "oz"
            )
        )

        val result = transformer.transform(viewModel)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `defaults currency to USD`() {
        val viewModel = QuantityPriceViewModel(
            type = QuantityPriceTypeViewModel.PRIMARY,
            price = PriceViewModel(
                value = BigDecimal.valueOf(13.00)
            ),
            quantity = QuantityViewModel(
                value = 8.0,
                unit = "oz"
            )
        )

        val expected = QuantityPrice(
            type = QuantityPriceType.PRIMARY,
            price = Price(
                value = BigDecimal.valueOf(13.00),
                currency = Currency.getInstance(Locale.US)
            ),
            quantity = Quantity(
                value = 8.0,
                unit = "oz"
            )
        )

        val result = transformer.transform(viewModel)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `defaults to USD for invalid currency code`() {
        val viewModel = QuantityPriceViewModel(
            type = QuantityPriceTypeViewModel.PRIMARY,
            price = PriceViewModel(
                value = BigDecimal.valueOf(13.00),
                currencyCode = "invalid"
            ),
            quantity = QuantityViewModel(
                value = 8.0,
                unit = "oz"
            )
        )

        val expected = QuantityPrice(
            type = QuantityPriceType.PRIMARY,
            price = Price(
                value = BigDecimal.valueOf(13.00),
                currency = Currency.getInstance(Locale.US)
            ),
            quantity = Quantity(
                value = 8.0,
                unit = "oz"
            )
        )

        val result = transformer.transform(viewModel)

        assertThat(result).isEqualTo(expected)
    }
}
