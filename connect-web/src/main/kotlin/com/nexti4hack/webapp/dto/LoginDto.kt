package com.nexti4hack.webapp.dto

/**
 * ログイン情報DTO
 */
data class LoginDto(
        // ユーザID
        var userId: String = "",
        // ログインID
        var loginId: String = "",
        // パスワード
        var password: String? = ""
)