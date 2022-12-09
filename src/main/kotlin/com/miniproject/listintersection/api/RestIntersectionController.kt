package com.miniproject.listintersection.api

import com.miniproject.listintersection.api.dto.RequestDto
import com.miniproject.listintersection.api.dto.ResultDto
import com.miniproject.listintersection.helpers.CollectionHelper
import com.miniproject.listintersection.service.IntersectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import kotlin.system.measureTimeMillis

@RestController
@RequestMapping("/api/intersection")
class RestIntersectionController @Autowired constructor(
    val intersectionService: IntersectionService
) {
    @GetMapping
    fun getIntersectionData(@Valid requestDto: RequestDto): ResultDto {
        val firstCollection = CollectionHelper.generateCollectionWithSize(requestDto.firstSize)
        val secondCollection = CollectionHelper.generateCollectionWithSize(requestDto.secondSize)

        val (collectionToPutInHashset, collectionToIterateOver) = CollectionHelper.sortCollections(
            requestDto.firstToHashSet,
            firstCollection,
            secondCollection
        )

        val intersection: Set<Int>
        val timeInMillis = measureTimeMillis {
            intersection = intersectionService.getIntersection(collectionToPutInHashset, collectionToIterateOver)
        }

        return ResultDto(
            firstCollection = firstCollection,
            secondCollection = secondCollection,
            intersection = intersection,
            intersectionSize = intersection.size,
            time = timeInMillis
        )
    }
}
