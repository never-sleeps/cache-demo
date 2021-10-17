package com.kotlin.cachedemo.repository

import com.kotlin.cachedemo.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author iakonyakina
 * @project cache-demo
 * @created 17/10/2021
 */
@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
}