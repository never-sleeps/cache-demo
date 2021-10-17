package com.kotlin.cachedemo.config

import org.springframework.cache.CacheManager
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.concurrent.ConcurrentMapCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit
import com.google.common.cache.CacheBuilder
import org.springframework.cache.Cache
import org.springframework.cache.annotation.EnableCaching


/**
 * @project cache-demo
 * @author iakonyakina
 * @created 17/10/2021
 */
@Configuration
@EnableCaching
class CacheConfig {
	@Bean
	fun cacheManager(): CacheManager {
		return object : ConcurrentMapCacheManager() {
			override fun createConcurrentMapCache(name: String): Cache {
				val store = CacheBuilder
					.newBuilder()
					.concurrencyLevel(4)
					.expireAfterWrite(10, TimeUnit.SECONDS) // время жизни значения в кэше после записи его в кэш
					.expireAfterAccess(5, TimeUnit.SECONDS) // время жизни значения в кэше после обращения к нему
					.maximumSize(256) // максимальный размер значений, которые может содержать кэш
					.build<Any, Any>()
					.asMap()
				return ConcurrentMapCache(name, store, false)
			}
		}
	}
}