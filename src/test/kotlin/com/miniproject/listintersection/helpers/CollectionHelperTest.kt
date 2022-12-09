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
    fun GivenFirstToHashSetTrue_WhenCallingSortCollections_ThenFirstCollectionIsPutToHashSetSecondCollectionIsToIterateOver() {
        val firstToHashSet = true
        val firstCollection = listOf(1, 2, 3)
        val secondCollection = listOf(5, 10, 15)

        val result = CollectionHelper.sortCollections(firstToHashSet, firstCollection, secondCollection)

        assertEquals(result.first, firstCollection)
        assertEquals(result.second, secondCollection)
    }

    @Test
    fun GivenFirstToHashSetFalse_WhenCallingSortCollections_ThenSecondCollectionIsPutToHashSetFirstCollectionIsToIterateOver() {
        val firstToHashSet = false
        val firstCollection = listOf(1, 2, 3)
        val secondCollection = listOf(5, 10, 15)

        val result = CollectionHelper.sortCollections(firstToHashSet, firstCollection, secondCollection)

        assertEquals(result.first, secondCollection)
        assertEquals(result.second, firstCollection)
    }
}