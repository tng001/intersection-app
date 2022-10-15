package com.miniproject.listintersection.service

import com.miniproject.listintersection.api.dto.RequestDto
import com.miniproject.listintersection.api.dto.ResultDto
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals

class GeneratorServiceTest {

    private lateinit var generatorService: GeneratorService

    @BeforeEach
    fun setUp() {
        generatorService = GeneratorService()
    }

    @Test
    @Ignore
    fun GivenRequestDto_WhenRequestIsProcessed_ThenResultIsGenerated() {
        val requestDto = RequestDto(
            firstSize = 3,
            secondSize = 4,
            toPutInHashset = "first",
            toIterateOver = "second"
        )

        val result = generatorService.getIntersectionData(requestDto)

        // the problem with this test is here
        // the random generator maybe can be tested using some seed's (I heard about this at one time but did not find resources to do it)
        // and the time also should be somehow Mocked, never done time Mocking
        val expectedResult = ResultDto(
            time = 1L,
            intersectionSize = 1,
            intersection = setOf(3),
            firstCollection = listOf(1, 2, 3),
            secondCollection = listOf(4, 5, 3),
        )
        assertEquals(result, expectedResult)
    }
}