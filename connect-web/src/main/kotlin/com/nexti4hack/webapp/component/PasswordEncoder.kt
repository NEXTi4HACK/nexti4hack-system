package com.nexti4hack.webapp.component

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

/**
 * パスワード暗号化/照合コンポーネント
 */
@Component
class PasswordEncoder {

    /**
     * パスワード暗号化
     * @param value パスワード(平文字)
     * @return パスワード(暗号化)
     */
    fun encode(value: String):String {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        return bCryptPasswordEncoder.encode(value)
    }

    /**
     * パスワード照合
     * @param rawPassword パスワード(平文字)
     * @param encodedPassword パスワード(暗号化)
     * @return true:一致 / false:不一致
     */
    fun matches(rawPassword: String, encodedPassword: String): Boolean {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword)
    }
}