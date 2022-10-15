package com.miniproject.listintersection.helpers

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CollectionHelperTest {

    @Test
    fun GivenSize_WhenCallingGenerateCollectionWithSize_ThenCollectionWithSizeIsReturned() {
        val size = 10

        val generatedCollection = CollectionHelper.generateCollectionWithSize(size)

        assertEquals(generatedCollection.size, size)
    }

    @Test
    fun GivenFirstCollectionAsTarget_WhenCallingGetCollectionToPutInHashset_ThenFirstCollectionIsReturned() {
        val toPutInHashset = "first"
        val firstCollection = listOf(1, 2, 3)
        val secondCollection = listOf(5, 10, 15)

        val result = CollectionHelper.getCollectionToPutInHashset(toPutInHashset, firstCollection, secondCollection)

        assertEquals(result, firstCollection)
    }

    @Test
    fun GivenSecondCollectionAsTarget_WhenCallingGetCollectionToIterateOver_ThenSecondCollectionIsReturned() {
        val toIterateOver = "second"
        val firstCollection = listOf(1, 2, 3)
        val secondCollection = listOf(5, 10, 15)

        val result = CollectionHelper.getCollectionToIterateOver(toIterateOver, firstCollection, secondCollection)

        assertEquals(result, secondCollection)
    }
}