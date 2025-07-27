package edu.unikom.latihanparsingapipublik.repository

import edu.unikom.latihanparsingapipublik.model.ResponseUser
import edu.unikom.latihanparsingapipublik.network.ApiConfig
import edu.unikom.latihanparsingapipublik.network.ApiService
import retrofit2.Call

class UserRepository(apiService: ApiService) {
    fun getUsers(page: String): Call<ResponseUser> {
        return ApiConfig.getApiService().getListUsers(page)
    }
}