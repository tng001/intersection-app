package com.miniproject.listintersection.helpers

import kotlin.random.Random

object CollectionHelper {
    fun generateCollectionWithSize(firstSize: Int): List<Int> {
        val ran = Random
        return IntArray(firstSize) { ran.nextInt(0, firstSize) }.asList()
    }

    fun sortCollections(
        firstToHashSet: Boolean,
        firstCollection: List<Int>,
        secondCollection: List<Int>,
    ): Pair<List<Int>, List<Int>> {
        return if (firstToHashSet) {
            Pair(firstCollection, secondCollection)
        } else {
            Pair(secondCollection, firstCollection)
        }
    }
}