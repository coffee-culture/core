package com.coffeeculture.core.transformers

import com.coffeeculture.core.models.event.Roaster
import com.coffeeculture.core.models.view.RoasterViewModel
import org.springframework.stereotype.Component

interface RoasterViewModelToEventTransformer :
    Transformer<Roaster, RoasterViewModel>

@Component
class RoasterViewModelToEventTransformerImpl :
    RoasterViewModelToEventTransformer {
    override fun transform(source: RoasterViewModel): Roaster {
        return Roaster(
            id = source.id,
            name = source.name
        )
    }
}
