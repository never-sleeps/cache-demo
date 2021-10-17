package com.kotlin.cachedemo.dto

import com.kotlin.cachedemo.domain.UserEntity

/**
 * @project cache-demo
 * @author iakonyakina
 * @created 17/10/2021
 */
data class UserDto(
	val id: Long,
	val name: String,
	val email: String?
) {
	constructor(user: UserEntity): this(
		id = user.id!!,
		name = user.name,
		email = user.email
	)
}