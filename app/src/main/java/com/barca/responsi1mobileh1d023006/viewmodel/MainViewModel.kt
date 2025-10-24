package com.barca.responsi1mobileh1d023006.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barca.responsi1mobile.data.network.RetrofitInstance
import com.barca.responsi1mobileh1d023006.data.model.TeamResponse
import com.barca.responsi1mobileh1d023006.utils.Constants
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _team = MutableLiveData<TeamResponse>()
    val team: LiveData<TeamResponse> = _team

    fun fetchTeam(teamId: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTeams(teamId, Constants.API_TOKEN)
                if (response.isSuccessful) {
                    _team.value = response.body()
                    Log.d("MainViewModel", "Data pelatih berhasil diambil: ${response.body()?.coach?.name}")
                } else {
                    Log.e("MainViewModel", "Gagal: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "Exception: ${e.localizedMessage}")
            }
        }
    }
}
