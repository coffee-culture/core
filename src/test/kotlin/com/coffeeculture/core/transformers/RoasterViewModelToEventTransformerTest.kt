package com.coffeeculture.core.transformers

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.coffeeculture.core.models.event.Roaster
import com.coffeeculture.core.models.view.RoasterViewModel
import org.junit.jupiter.api.Test

class RoasterViewModelToEventTransformerTest {

    @Test
    fun `transforms roaster view model to event model`() {
        val viewModel = RoasterViewModel(
            id = "123xyz",
            name = "Test Roaster"
        )

        val expectedEventModel = Roaster(
            id = "123xyz",
            name = "Test Roaster"
        )

        val result = RoasterViewModelToEventTransformerImpl().transform(viewModel)

        assertThat(result).isEqualTo(expectedEventModel)
    }
}
