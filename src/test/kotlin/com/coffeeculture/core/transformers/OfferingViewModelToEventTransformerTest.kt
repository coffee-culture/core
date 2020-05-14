package com.coffeeculture.core.transformers

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.coffeeculture.core.testdata.events.OfferingEventTestData
import com.coffeeculture.core.testdata.view.OfferingsViewModelTestData
import org.junit.jupiter.api.Test

class OfferingViewModelToEventTransformerTest {

    private val transformer = OfferingViewModelToEventTransformerImpl(
        toQuantityPriceTransformer = QuantityPriceViewModelToEventTransformerImpl(),
        toRoasterEventTransformer = RoasterViewModelToEventTransformerImpl()
    )

    @Test
    fun `transforms offering view model to event model`() {
        val viewModel = OfferingsViewModelTestData.littleWolfOfferings()
        val expected = listOf(
            OfferingEventTestData.ethiopiaNanoGenjiLittleWolf()
        )

        val result = transformer.transform(viewModel)

        assertThat(result).isEqualTo(expected)
    }
}
