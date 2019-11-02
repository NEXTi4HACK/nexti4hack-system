package com.nexti4hack.webapp.mapper

import org.apache.ibatis.annotations.Mapper

/**
 * ファンクション呼び出し
 */
@Mapper
interface CustomFunctionMapper {

    // key取得
    fun selectKeyValue(): String
}