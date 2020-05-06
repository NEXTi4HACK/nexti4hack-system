package com.nexti4hack.api.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class UserInfoController {

    @RequestMapping(value = ["/userinfo"], method = [RequestMethod.POST])
    @ResponseBody
    fun userInfo(): String {
        return ""
    }
}