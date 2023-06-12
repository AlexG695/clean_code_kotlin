package com.sixforyeit.bank.core.network.response

import com.google.gson.annotations.SerializedName


//ESTRUCTURA DE DATOS DE LA RESPUESTA DEL LOGIN QUE MANDA EL API
data class LoginResponse(
    @field:SerializedName("session")
    val session: session,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("tarjeta")
    val tarjeta: tarjeta,

    @field:SerializedName("user")
    val user: user

)

    //ESTRUCTURA DE DATOS DE LA SESIÓN DEL USUARIO
    data class session(
        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("email")
        val email: String,

        @field:SerializedName("refresh_token")
        val refresh_token: String,

        @field:SerializedName("is_blocked")
        val is_blocked: Boolean,

        @field:SerializedName("expire_at")
        val expire_at: String,

        @field:SerializedName("created_at")
        val created_at: String
    )



    //ESTRUCTURA DE DATOS DE LA TARJETA
    data class tarjeta(
        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("owner")
        val owner: Int,

        @field:SerializedName("number")
        val number: String,

        @field:SerializedName("caduca")
        val caduca: String,

        @field:SerializedName("cvv")
        val cvv: String,

        @field:SerializedName("active")
        val active: Boolean,

        @field:SerializedName("tipo_tarjeta")
        val tipo_tarjeta: String,

        @field:SerializedName("updated_at")
        val updated_at: String

    )

    data class user(
        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("lastname")
        val lastname: String,

        @field:SerializedName("phone")
        val phone: String,

        @field:SerializedName("birth")
        val birth: String,

        @field:SerializedName("lat")
        val lat: String,

        @field:SerializedName("lng")
        val lng: String,

        @field:SerializedName("email")
        val email: String,

        @field:SerializedName("pass")
        val pass: String,

        @field:SerializedName("verified")
        val verified: Boolean,

        @field:SerializedName("balance")
        val balance: Double,

        @field:SerializedName("currency")
        val currency: String,

        @field:SerializedName("number_account")
        val number_account: String,

        @field:SerializedName("secret_code")
        val secret_code: String,

        @field:SerializedName("curp")
        val curp: String,

        @field:SerializedName("creted_at")
        val creted_at: String
    )
{
}