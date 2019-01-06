package com.nexti4hack.webapp.dto

data class LoginDto(
        // ユーザID
        var userId: String = "",
        // ログインID
        var loginId: String = "",
        // パスワード
        var password: String = ""
)