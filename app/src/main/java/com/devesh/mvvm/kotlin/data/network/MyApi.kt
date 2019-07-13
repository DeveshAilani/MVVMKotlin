package com.devesh.mvvm.kotlin.data.network

import com.devesh.mvvm.kotlin.data.network.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    // userLogin is long running network call that is why we mentioned as suspend
    suspend fun userLogin(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Response<AuthResponse>//Call<ResponseBody>

    companion object {
        operator fun invoke() : MyApi {
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}