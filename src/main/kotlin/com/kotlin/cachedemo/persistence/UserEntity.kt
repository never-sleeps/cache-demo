package com.kotlin.cachedemo.persistence

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class UserEntity (
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long,

	@Column(name = "name")
	val name: String,

	@Column(name = "birthday")
	val birthday: LocalDate?,

	@Column(name = "email")
	val email: String?
)