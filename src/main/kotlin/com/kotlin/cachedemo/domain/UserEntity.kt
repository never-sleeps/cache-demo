package com.kotlin.cachedemo.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * @author iakonyakina
 * @project cache-demo
 * @created 17/10/2021
 */
@Entity
@Table(name = "users")
data class UserEntity (
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null,

	@Column(name = "name")
	val name: String,

	@Column(name = "email")
	val email: String?
) {
	constructor(
		name: String,
		email: String? = null
	) : this(
		id = null,
		name = name,
		email = email
	)
}