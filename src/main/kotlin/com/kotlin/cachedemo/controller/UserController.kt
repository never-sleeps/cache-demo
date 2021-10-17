package com.kotlin.cachedemo.controller

import com.kotlin.cachedemo.domain.UserEntity
import com.kotlin.cachedemo.dto.UserDto
import com.kotlin.cachedemo.service.UserService
import org.springframework.context.ApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * @project cache-demo
 * @author iakonyakina
 * @created 17/10/2021
 */
@RestController
@RequestMapping("/api/v1/users")
class UserController(
	private val userService: UserService,
	private val applicationContext: ApplicationContext // for debug
) {
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/{id}")
	fun get(@PathVariable id: Long) = userService.get(id)
		.let { UserDto(it) }

	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping
	fun findAll() = userService.findAll()
		.map { UserDto(it) }

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	fun create(@RequestBody dto: UserDto) = UserEntity(dto.name, dto.email)
		.let { userService.create(it) }
		.let { UserDto(it) }

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	fun delete(@PathVariable id: Long) = userService.deleteById(id)
}