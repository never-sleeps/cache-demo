package com.kotlin.cachedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author iakonyakina
 * @project cache-demo
 * @created 17/10/2021
 */
@SpringBootApplication
class CacheDemoApplication

fun main(args: Array<String>) {
	runApplication<CacheDemoApplication>(*args)
}
