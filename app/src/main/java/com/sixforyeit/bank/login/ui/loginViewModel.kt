package com.sixforyeit.bank.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sixforyeit.bank.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){

    val loginUseCase = LoginUseCase()

    //LA VISTA SOLO PUEDE LEER LOS DATOS PERO NO MODIFICARLOS
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _pass = MutableLiveData<String>()
    val pass : LiveData<String> = _pass

    private val _isLoginEnble = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnble

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, pass: String){
        _email.value = email
        _pass.value = pass
        _isLoginEnble.value = enableLogin(email, pass)
    }

    fun enableLogin(email: String, pass: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && pass.length > 6

    fun onLoginSelected(){
        //LANZAR EL VIEW MODEL
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, pass.value!!)
            if(result){
                Log.i("OK", "TODO BIEN")
            }
            _isLoading.value = false
        }
    }
}