package com.miniproject.listintersection.api.dto

class ResultDto(
    var time: Long,
    var intersectionSize: Int,
    var intersection: Set<Int>,
    var firstCollection: List<Int>,
    var secondCollection: List<Int>
)