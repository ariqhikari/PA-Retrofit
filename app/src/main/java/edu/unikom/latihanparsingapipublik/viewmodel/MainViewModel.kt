package edu.unikom.latihanparsingapipublik.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unikom.latihanparsingapipublik.model.DataItem
import edu.unikom.latihanparsingapipublik.model.ResponseUser
import edu.unikom.latihanparsingapipublik.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _users = MutableLiveData<List<DataItem>>()
    val users: LiveData<List<DataItem>> = _users

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchUsers(page: String) {
        userRepository.getUsers(page).enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful) {
                    _users.value = response.body()?.data ?: emptyList()
                } else {
                    _error.value = "Failed to load users"
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                _error.value = t.message
            }
        })
    }
}