package com.kotlin.cachedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CacheDemoApplication

fun main(args: Array<String>) {
	runApplication<CacheDemoApplication>(*args)
}
