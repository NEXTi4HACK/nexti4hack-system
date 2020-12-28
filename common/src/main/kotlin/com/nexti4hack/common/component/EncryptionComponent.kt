package com.nexti4hack.common.component

import com.nexti4hack.common.custom.mapper.CustomFunctionMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * 暗号化/復号コンポーネント
 */
@Component
class EncryptionComponent {

    @Autowired
    lateinit var customFunctionMapper: CustomFunctionMapper

    companion object {
        /* アルゴリズム */
        const val ALGORITHM: String = "AES"
    }

    // 暗号化キー
    var keyBytes: ByteArray? = null

    @PostConstruct
    fun init() {
        // 暗号化/複合キーを取得
        keyBytes = customFunctionMapper.selectKeyValue().toByteArray(Charsets.UTF_8).copyOf(16)
    }

    /**
     * 暗号化
     * @param value 暗号化対象文字列
     * @return 暗号化値(バイナリ)
     */
    fun aesEncrypt(value: String): ByteArray {
        val key = SecretKeySpec(keyBytes, ALGORITHM)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        // 暗号化して返却(Byte)
        return cipher.doFinal(value.toByteArray(Charsets.UTF_8))
    }

    /**
     * 復号
     * @param value 暗号値(バイナリ)
     * @return 復号値(文字列)
     */
    fun aesDecrypt(value: ByteArray?): String {
        val key = SecretKeySpec(keyBytes, ALGORITHM)
        val decipher = Cipher.getInstance(ALGORITHM)
        decipher.init(Cipher.DECRYPT_MODE, key)

        // 復号して返却(String)
        return String(decipher.doFinal(value))
    }
}