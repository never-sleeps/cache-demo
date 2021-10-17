package com.kotlin.cachedemo.service

import mu.KotlinLogging
import com.kotlin.cachedemo.domain.UserEntity
import com.kotlin.cachedemo.repository.UserRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

/**
 * @author iakonyakina
 * @project cache-demo
 * @created 17/10/2021
 */
@Service
class UserServiceImpl(
	private val userRepository: UserRepository
) : UserService {

	@CachePut("users", key = "#userEntity.id")
	override fun create(userEntity: UserEntity): UserEntity = userRepository.save(userEntity)
		.also { log.info("saved user {}", it) }

	@Cacheable("users", key = "#id")
	override fun get(id: Long): UserEntity = userRepository.findById(id)
		.orElseThrow { EntityNotFoundException("User not found by id $id") }
		.also { log.info("from db: received user {}", it) }

	override fun findAll(): List<UserEntity> = userRepository.findAll()
		.also { log.info("from db: received total users {}", it.size) }

	@CacheEvict("users")
	override fun deleteById(id: Long): Unit = userRepository.findById(id)
		.orElseThrow { EntityNotFoundException("User not found by id $id") }
		.let { userRepository.delete(it) }
		.also { log.info("from db: deleted user with id {}", id) }

	companion object {
		private val log = KotlinLogging.logger { }
	}
}