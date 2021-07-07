package com.coffeeculture.core.transformers

interface Transformer<T, I> {
    fun transform(source: I): T
}
