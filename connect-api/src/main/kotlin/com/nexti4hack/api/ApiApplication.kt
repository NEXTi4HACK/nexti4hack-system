package com.nexti4hack.api

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan("com.nexti4hack")
@SpringBootApplication(scanBasePackages=["com.nexti4hack"])
class ApiApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            runApplication<ApiApplication>(*args)
        }
    }
}