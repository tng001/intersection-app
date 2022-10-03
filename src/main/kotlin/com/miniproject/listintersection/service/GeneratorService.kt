package com.miniproject.listintersection.service

import com.miniproject.listintersection.api.dto.RequestDto
import com.miniproject.listintersection.api.dto.ResultDto
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class GeneratorService {
    fun getIntersectionData(requestDto: RequestDto): ResultDto {
        val startTime = System.nanoTime()

        val (firstCollection, secondCollection) = generateLists(requestDto.firstSize, requestDto.secondSize)

        val collectionToPutInHashset =
            getCollectionToPutInHashset(requestDto.toPutInHashset, firstCollection, secondCollection)
        val collectionToIterateOver =
            getCollectionToIterateOver(requestDto.toIterateOver, firstCollection, secondCollection)

        val intersection = getIntersection(collectionToPutInHashset, collectionToIterateOver)
        val intersectionSize = intersection.size

        val endTime = System.nanoTime() - startTime

        return ResultDto(
            firstCollection = firstCollection,
            secondCollection = secondCollection,
            intersection = intersection,
            intersectionSize = intersectionSize,
            time = endTime
        )
    }

    private fun generateLists(firstSize: Int, secondSize: Int): List<List<Int>> {
        val ran = Random
        val firstCollection = IntArray(firstSize) { ran.nextInt(0, 100) }.asList()
        val secondCollection = IntArray(secondSize) { ran.nextInt(0, 100) }.asList()
        return listOf(firstCollection, secondCollection)
    }

    private fun getCollectionToPutInHashset(
        toPutInHashset: String,
        firstCollection: List<Int>,
        secondCollection: List<Int>,
    ): List<Int> = if (toPutInHashset == "first") firstCollection else secondCollection

    private fun getCollectionToIterateOver(
        toIterateOver: String,
        firstCollection: List<Int>,
        secondCollection: List<Int>
    ): List<Int> = if (toIterateOver == "first") firstCollection else secondCollection

    private fun getIntersection(
        collectionToPutInHashset: List<Int>,
        collectionToIterateOver: List<Int>
    ): Set<Int> {
        val set = mutableSetOf<Int>()
        val intersection = mutableSetOf<Int>()

        collectionToPutInHashset.forEach { set.add(it) }
        collectionToIterateOver.forEach { if (set.contains(it)) intersection.add(it) }

        return intersection
    }
}