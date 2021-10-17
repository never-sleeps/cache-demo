package com.kotlin.cachedemo.exception

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.lang.RuntimeException

/**
 * @project cache-demo
 * @author iakonyakina
 * @created 17/10/2021
 */
@ControllerAdvice(basePackages = ["com.kotlin.cachedemo.controller"])
class ControllerAdvice {
	@ResponseBody
	@ExceptionHandler(value = [(RuntimeException::class)])
	fun applicationException(e: RuntimeException): ResponseEntity<ErrorResponse> {
		log.error("Exception", e)
		return ResponseEntity(
			ErrorResponse(e.localizedMessage),
			HttpStatus.INTERNAL_SERVER_ERROR
		)
	}

	companion object {
		val log = KotlinLogging.logger {}
	}
}

data class ErrorResponse(
	val message: String
)