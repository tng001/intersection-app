package com.miniproject.listintersection.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    @GetMapping
    fun getDefaultMainPage(model: Model): String {
        return "main"
    }
}
