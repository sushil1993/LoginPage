package sushillogin.network

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import sushillogin.models.LoginModel


interface ApiService
{
    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email: String, @Field("password") password: String):Observable<LoginModel>

}