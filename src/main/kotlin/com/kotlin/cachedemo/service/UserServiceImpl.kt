package com.kotlin.cachedemo.service

import mu.KotlinLogging
import com.kotlin.cachedemo.persistence.UserEntity
import com.kotlin.cachedemo.persistence.UserRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class UserServiceImpl(
	private val userRepository: UserRepository
) : UserService {

	override fun create(userEntity: UserEntity): UserEntity = userRepository.save(userEntity)
		.also { log.info("saved user {}", it) }


	override fun get(id: Long): UserEntity = userRepository.findById(id)
		.orElseThrow { EntityNotFoundException("User not found by id $id") }
		.also { log.info("received user {}", it) }

	companion object {
		private val log = KotlinLogging.logger { }
	}
}