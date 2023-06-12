package com.sixforyeit.bank.login.data.network

import com.sixforyeit.bank.core.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.POST

interface LoginClient {
    @POST("/api/user/LogIn")
    suspend fun doLogin():Response<LoginResponse>


}