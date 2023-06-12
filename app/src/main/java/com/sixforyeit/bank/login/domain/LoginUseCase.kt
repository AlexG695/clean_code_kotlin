package com.sixforyeit.bank.login.domain

import com.sixforyeit.bank.login.data.network.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(email: String, pass: String):Boolean{
        return repository.doLogin(email, pass)
    }
}