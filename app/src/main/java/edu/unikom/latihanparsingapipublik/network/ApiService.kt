package edu.unikom.latihanparsingapipublik.network

import edu.unikom.latihanparsingapipublik.model.ResponseUser
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("api/users")
    fun getListUsers(@Query("page") page: String): Call<ResponseUser>
}