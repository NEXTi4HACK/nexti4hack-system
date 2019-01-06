package com.nexti4hack.webapp

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan("com.nexti4hack.db.mapper,com.nexti4hack.webapp.mapper")
@SpringBootApplication
class WebappApplication

fun main(args: Array<String>) {
	runApplication<WebappApplication>(*args)
}

