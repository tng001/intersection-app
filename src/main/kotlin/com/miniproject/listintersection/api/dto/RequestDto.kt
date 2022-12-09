package com.miniproject.listintersection.api.dto

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class RequestDto(
    @field:NotNull(message = "{request.list.notnull.message}")
    @field:Positive(message = "{request.list.positive.message}")
    @field:Min(value = 0, message = "{request.list.minsize.message}")
    @field:Max(value = 1000000, message = "{request.list.maxsize.message}")
    var firstSize: Int,

    @field:NotNull(message = "{request.list.notnull.message}")
    @field:Positive(message = "{request.list.positive.message}")
    @field:Min(value = 0, message = "{request.list.minsize.message}")
    @field:Max(value = 1000000, message = "{request.list.maxsize.message}")
    var secondSize: Int,

    var firstToHashSet: Boolean,
)