package com.sixforyeit.bank.login.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val isLoading: Boolean by loginViewModel.isLoading.observeAsState(initial = false)
        if(isLoading){
            Box(
                Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)){
                CircularProgressIndicator()
            }
        }else{
            Body(Modifier.align(Alignment.Center), loginViewModel)
        }

    }
}

@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val pass: String by loginViewModel.pass.observeAsState(initial = "")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(false)
    Column(modifier = modifier) {
        MensajeBienvenida(bienvenida = "Bienvenido, ingresa tus credenciales para continuar.")
        Spacer(modifier = Modifier.size(16.dp))
        Email(email) {
            loginViewModel.onLoginChanged(email = it, pass = pass)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Pass(pass) {
            loginViewModel.onLoginChanged(email = email, pass = it)
        }
        Spacer(modifier = Modifier.size(32.dp))
        LoginButton(isLoginEnable, loginViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pass(pass: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = pass,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Contraseña") },
        onValueChange = { onTextChanged(it) },
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "Mostrar contraseña")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Correo") },
        onValueChange = { onTextChanged(it) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun MensajeBienvenida(bienvenida: String) {
    Text(
        text = bienvenida, style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    )
}


@Composable
fun LoginButton(loginEnable: Boolean, loginViewModel: LoginViewModel) {
    Button(
        onClick = {
            if(loginEnable){
                loginViewModel.onLoginSelected()
            } else{

            }
        },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            disabledContentColor = Color.Gray,
            containerColor = Color.Red
        )
    ) {
        Text(text = "Iniciar sesión")
    }
}