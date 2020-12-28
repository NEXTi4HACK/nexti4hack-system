package com.nexti4hack.common.custom.mapper

import org.apache.ibatis.annotations.Mapper

/**
 * ファンクション呼び出し
 */
@Mapper
interface CustomFunctionMapper {

    // key取得
    fun selectKeyValue(): String
}