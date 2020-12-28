package com.nexti4hack.api.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class UserInfoController {

    @RequestMapping(value = ["/info"], method = [RequestMethod.POST])
    @ResponseBody
    fun userInfo(): String {
        return ""
    }
}