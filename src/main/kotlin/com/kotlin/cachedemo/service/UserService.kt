package com.kotlin.cachedemo.service

import com.kotlin.cachedemo.persistence.UserEntity

interface UserService {
	fun create(userEntity: UserEntity): UserEntity

	fun get(id: Long): UserEntity
}