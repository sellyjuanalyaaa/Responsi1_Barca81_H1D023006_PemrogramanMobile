package com.barca.responsi1mobileh1d023006

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.barca.responsi1mobile.data.network.RetrofitInstance
import com.barca.responsi1mobileh1d023006.databinding.ActivityCoachBinding
import kotlinx.coroutines.launch
import com.barca.responsi1mobileh1d023006.viewmodel.MainViewModel;

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val teamId = "81"
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchTeam(teamId)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.team.observe(this) { team ->
            val coach = team?.coach
            if (coach != null) {
                binding.tvCoachName.text = coach.name ?: "N/A"
                binding.tvCoachNationality.text = coach.nationality ?: "N/A"
                binding.tvCoachBirth.text = coach.dateOfBirth ?: "N/A"
            } else {
                binding.tvCoachName.text = "Data pelatih tidak ditemukan"
            }
        }
    }
}
