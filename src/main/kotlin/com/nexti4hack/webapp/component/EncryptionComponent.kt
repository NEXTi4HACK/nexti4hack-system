package com.nexti4hack.webapp.component

import com.nexti4hack.webapp.mapper.CustomFunctionMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec


/**
 * 暗号化/復号化コンポーネント
 */
@Component
open class EncryptionComponent {

    // CustomMapper
    @Autowired
    lateinit var customFunctionMapper: CustomFunctionMapper

    companion object {
        /* アルゴリズム */
        const val ALGORITHM :String = "AES"
    }

    /**
     * 暗号化
     */
    fun aesEncrypt(value: String): ByteArray {
        // 暗号化キーを設定
        val keyBytes = Arrays.copyOf(customFunctionMapper.selectKeyValue().toByteArray(Charsets.UTF_8), 16)

        var key = SecretKeySpec(keyBytes, ALGORITHM)
        var cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        // 暗号化して返却(Byte)
        return cipher.doFinal(value.toByteArray(Charsets.UTF_8))
    }

    /**
     * 復号化
     */
    fun aesDecrypt(value: ByteArray?): String {
        // 復号化キーを設定
        val keyBytes = Arrays.copyOf(customFunctionMapper.selectKeyValue().toByteArray(Charsets.UTF_8), 16)

        var key = SecretKeySpec(keyBytes, ALGORITHM)
        var decipher = Cipher.getInstance(ALGORITHM)
        decipher.init(Cipher.DECRYPT_MODE, key)

        // 復号化して返却(String)
        return String(decipher.doFinal(value))
    }
}