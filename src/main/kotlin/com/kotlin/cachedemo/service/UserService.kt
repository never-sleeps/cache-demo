package com.kotlin.cachedemo.service

import com.kotlin.cachedemo.domain.UserEntity

/**
 * @author iakonyakina
 * @project cache-demo
 * @created 17/10/2021
 */
interface UserService {

	fun create(userEntity: UserEntity): UserEntity

	fun get(id: Long): UserEntity

	fun findAll(): List<UserEntity>

	fun deleteById(id: Long)
}