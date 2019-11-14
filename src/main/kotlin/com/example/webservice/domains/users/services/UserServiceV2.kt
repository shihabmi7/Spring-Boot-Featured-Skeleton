package com.example.webservice.domains.users.services

import com.example.webservice.domains.users.models.entities.User
import java.util.*
import javax.transaction.Transactional

interface UserServiceV2 {
    fun save(user: User) : User
    fun register(token: String, user: User): User
    fun requireAccountValidationByOTP(phoneOrEmail: String, tokenValidUntil: Date): Boolean
    fun find(id: Long): Optional<User>
    fun findByUsername(username: String): Optional<User>
    fun findByPhone(phone: String): Optional<User>
    fun findByEmail(email: String): Optional<User>

    fun changePassword(id: Long, currentPassword: String, newPassword: String): User
    fun setPassword(id: Long, newPassword: String): User
    fun handlePasswordResetRequest(username: String)
    fun setRoles(id: Long, roleIds: List<Long>): User

    @Transactional
    fun resetPassword(username: String, token: String, password: String): User

}
