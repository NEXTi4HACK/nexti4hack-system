package com.nexti4hack.webapp.controller

import com.nexti4hack.webapp.enumeration.ViewName
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

/**
 * ログインコントロール
 */
@Controller
class LoginController {

    /**
     * ログイン画面
     */
    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    fun login(): ModelAndView {
        var mav = ModelAndView(ViewName.LOGIN.htmlName)
        return mav
    }
}