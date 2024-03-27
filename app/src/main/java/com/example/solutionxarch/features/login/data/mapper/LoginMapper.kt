package com.example.solutionxarch.features.login.data.mapper

import com.example.solutionxarch.core.data.mapper.Mapper
import com.example.solutionxarch.features.login.data.models.UserEntity
import com.example.solutionxarch.features.login.data.models.UserDto
import com.example.solutionxarch.features.login.data.models.UserLoginDto
import com.example.solutionxarch.features.login.domain.models.User

object LoginMapper: Mapper<User, UserLoginDto, UserEntity> {

    override fun toDomain(data: UserLoginDto): User {
        return User(
            username = data.user.username,
            token = data.token
        )
    }

    override fun toData(domain: User): UserLoginDto {
       TODO()
    }

    override fun toEntity(domain: User): UserEntity {
        return UserEntity(
            username = domain.username,
            token = domain.token
        )
    }

    override fun fromEntityToDomain(entity: UserEntity): User {
        return User(
            username = entity.username,
            token = entity.token
        )
    }
}