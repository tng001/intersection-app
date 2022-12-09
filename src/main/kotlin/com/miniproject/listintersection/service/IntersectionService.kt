package com.miniproject.listintersection.service

import org.springframework.stereotype.Service

@Service
class IntersectionService {
    fun getIntersection(
        collectionToPutInHashset: List<Int>,
        collectionToIterateOver: List<Int>
    ): Set<Int> {
        val set = HashSet(collectionToPutInHashset)
        val intersection = mutableSetOf<Int>()
        return collectionToIterateOver.filterTo(intersection, set::contains)
    }
}
