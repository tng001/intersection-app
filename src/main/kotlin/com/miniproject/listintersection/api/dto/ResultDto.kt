package com.miniproject.listintersection.api.dto

class ResultDto(
    val time: Long,
    val intersectionSize: Int,
    val intersection: Set<Int>,
    val firstCollection: List<Int>,
    val secondCollection: List<Int>
)