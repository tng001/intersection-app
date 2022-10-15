package com.miniproject.listintersection.helpers

import kotlin.random.Random

object CollectionHelper {
    fun generateCollectionWithSize(firstSize: Int): List<Int> {
        val ran = Random
        return IntArray(firstSize) { ran.nextInt(0, 100) }.asList()
    }

    fun getCollectionToPutInHashset(
        toPutInHashset: String,
        firstCollection: List<Int>,
        secondCollection: List<Int>,
    ): List<Int> = getCollection(toPutInHashset, firstCollection, secondCollection)

    fun getCollectionToIterateOver(
        toIterateOver: String,
        firstCollection: List<Int>,
        secondCollection: List<Int>
    ): List<Int> = getCollection(toIterateOver, firstCollection, secondCollection)

    private fun getCollection(
        target: String,
        firstCollection: List<Int>,
        secondCollection: List<Int>
    ): List<Int> = if (target == "first") firstCollection else secondCollection
}