package com.sixforyeit.bank.login.data.network

import com.sixforyeit.bank.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    //CONSUMIR LA PETICIÓN DESDE CLIENT
    suspend fun  doLogin(email: String, pass: String):Boolean{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success ?: false
        }
    }
}