package com.nexti4hack.webapp.security

import com.nexti4hack.common.component.PasswordEncoder
import com.nexti4hack.webapp.dto.LoginDto
import com.nexti4hack.webapp.mapper.CustomUsersMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

/**
 * ログイン認証
 */
@Component
open class AuthenticationProviderImpl: AuthenticationProvider {

    // ログ
    private val log = LoggerFactory.getLogger(AuthenticationProviderImpl::class.java)

    // Component
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    // CustomMapper
    @Autowired
    lateinit var customUsersMapper: CustomUsersMapper

    // 認証処理
    override fun authenticate(authentication: Authentication): UsernamePasswordAuthenticationToken {

        val loginDto = authentication.principal as LoginDto
        // パスワード(入力値)
        val password = authentication.credentials.toString()

        // 入力されたログインIDからユーザ情報を取得
        val customUsersModel = customUsersMapper.selectByLoginId(loginDto.loginId) ?: throw BadCredentialsException("")

        // 取得できなかった場合、認証失敗
        // パスワード照合で不一致の場合、認証失敗
        if (!passwordEncoder.matches(password, customUsersModel.password)) {
            throw BadCredentialsException("")
        }

        loginDto.userId = customUsersModel.userId

        log.info("Login Successfully userId:${loginDto.userId}")
        return UsernamePasswordAuthenticationToken(loginDto, password, authentication.authorities)
    }

    override fun supports(authentication: Class<*>): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}