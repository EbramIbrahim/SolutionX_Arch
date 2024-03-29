package com.example.solutionxarch.features.login.domain.usecase

import com.example.solutionxarch.core.common.SolutionXException
import com.example.solutionxarch.features.login.domain.repository.LoginRepository
import com.example.solutionxarch.features.login.domain.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.solutionxarch.core.common.Result
import retrofit2.HttpException
import java.io.IOException

class LoginWithSocialUC(
    private val loginRepository: LoginRepository
) {

    operator fun invoke(): Flow<Result<User, SolutionXException>> = flow {

        try {
            val user = loginRepository.loginUserWithSocial()
            emit(Result.Success(user))
        } catch (e: Exception) {}
    }
}