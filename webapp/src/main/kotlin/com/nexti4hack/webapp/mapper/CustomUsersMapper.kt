package com.nexti4hack.webapp.mapper

import com.nexti4hack.webapp.model.CustomUsersModel
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CustomUsersMapper {

    // ログインIDからユーザ情報を取得
    fun selectByLoginId(userId: String): CustomUsersModel
}