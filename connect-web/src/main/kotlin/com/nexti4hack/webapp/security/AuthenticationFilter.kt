package com.nexti4hack.webapp.security

import com.nexti4hack.webapp.dto.LoginDto
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * ログイン認証フィルタ
 */
open class AuthenticationFilter: UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val loginDto = LoginDto()
        loginDto.loginId = request.getParameter("loginId")
        loginDto.password = obtainPassword(request)

        val authRequest = UsernamePasswordAuthenticationToken(loginDto, obtainPassword(request))
        setDetails(request, authRequest)
        return this.authenticationManager.authenticate(authRequest)
    }
}