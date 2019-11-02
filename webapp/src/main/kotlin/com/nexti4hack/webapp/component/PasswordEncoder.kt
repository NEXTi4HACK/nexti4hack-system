package com.nexti4hack.webapp.component

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

/**
 * パスワード暗号化/照合コンポーネント
 */
@Component
open class PasswordEncoder {

    /**
     * パスワード暗号化
     */
    fun encode(value: String):String {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        return bCryptPasswordEncoder.encode(value)
    }

    /**
     * パスワード照合
     */
    fun matches(rawPassword: String, encodedPassword: String): Boolean {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword)
    }
}