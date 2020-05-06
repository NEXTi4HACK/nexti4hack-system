package com.nexti4hack.webapp.model

import java.util.*

/**
 * ユーザ情報カスタムモデル
 */
class CustomUsersModel {
        var userId: String = ""
        var loginId: ByteArray? = null
        var password: String = ""
        var createDate: Date? = null
        var updateDate: Date? = null
        var createUser: String = ""
        var updateUser: String = ""
}
