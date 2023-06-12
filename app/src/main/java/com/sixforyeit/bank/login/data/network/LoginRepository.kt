package com.sixforyeit.bank.login.data.network

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(email: String, pass: String):Boolean{
        return api.doLogin(email, pass)
    }
}