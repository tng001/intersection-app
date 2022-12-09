package com.miniproject.listintersection.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IntersectionServiceTest {

    private lateinit var intersectionService: IntersectionService

    @BeforeEach
    fun setUp() {
        intersectionService = IntersectionService()
    }

    @Test
    fun GivenCollectionsWithIntersection_WhenGetIntersectionIsCalled_ThenIntersectionIsGenerated() {
        val firstCollection = listOf(1, 2, 3)
        val secondCollection = listOf(3, 4, 5)

        val result = intersectionService.getIntersection(firstCollection, secondCollection)

        assertEquals(result, setOf(3))
    }

    @Test
    fun GivenCollectionsWithoutIntersection_WhenGetIntersectionIsCalled_ThenEmptyIntersectionIsGenerated() {
        val firstCollection = listOf(1, 2, 3)
        val secondCollection = listOf(5, 6, 7)

        val result = intersectionService.getIntersection(firstCollection, secondCollection)

        assertEquals(result, emptySet())
    }
}
