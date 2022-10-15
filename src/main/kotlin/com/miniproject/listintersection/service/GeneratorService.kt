package com.miniproject.listintersection.service

import com.miniproject.listintersection.api.dto.RequestDto
import com.miniproject.listintersection.api.dto.ResultDto
import com.miniproject.listintersection.helpers.CollectionHelper
import org.springframework.stereotype.Service

@Service
class GeneratorService {
    fun getIntersectionData(requestDto: RequestDto): ResultDto {
        val startTime = System.nanoTime()

        val firstCollection = CollectionHelper.generateCollectionWithSize(requestDto.firstSize)
        val secondCollection = CollectionHelper.generateCollectionWithSize(requestDto.secondSize)
        val collectionToPutInHashset =
            CollectionHelper.getCollectionToPutInHashset(requestDto.toPutInHashset, firstCollection, secondCollection)
        val collectionToIterateOver =
            CollectionHelper.getCollectionToIterateOver(requestDto.toIterateOver, firstCollection, secondCollection)

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