package com.nexti4hack.webapp.component

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
open class PasswordEncoder {

    fun encode(value: String):String {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        return bCryptPasswordEncoder.encode(value)
    }

    fun matches(rawPassword: String, encodedPassword: String): Boolean {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword)
    }
}