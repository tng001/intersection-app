package com.miniproject.listintersection.api

import com.miniproject.listintersection.api.dto.RequestDto
import com.miniproject.listintersection.api.dto.ResultDto
import com.miniproject.listintersection.service.GeneratorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/intersection")
class RestIntersectionController @Autowired constructor(
    val generatorService: GeneratorService
) {
    @GetMapping
    fun getIntersectionData(@Valid requestDto: RequestDto): ResultDto {
        return generatorService.getIntersectionData(requestDto)
    }
}