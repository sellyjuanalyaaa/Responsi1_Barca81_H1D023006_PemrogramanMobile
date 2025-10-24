// Kotlin
package com.barca.responsi1mobileh1d023006

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.barca.responsi1mobile.data.network.RetrofitInstance
import com.barca.responsi1mobileh1d023006.adapter.TeamAdapter
import com.barca.responsi1mobileh1d023006.data.model.Player
import com.barca.responsi1mobileh1d023006.databinding.ActivityTeamBinding
import com.barca.responsi1mobileh1d023006.fragment.TeamDetailFragment
import com.barca.responsi1mobileh1d023006.utils.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamBinding
    private val TAG = "TeamActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchPlayerData()
    }

    private fun fetchPlayerData() {
        lifecycleScope.launch {
            val maxRetries = 2
            var attempt = 0

            while (attempt <= maxRetries) {
                try {
                    attempt++
                    Log.d(TAG, "Fetching teams, attempt $attempt")
                    val response = RetrofitInstance.api.getTeams(Constants.TEAM_ID, Constants.API_TOKEN)

                    if (response.isSuccessful) {
                        val squad = response.body()?.squad ?: emptyList()
                        Log.d(TAG, "Loaded squad size=${squad.size}")
                        setupRecyclerView(squad)
                        return@launch
                    } else {
                        Log.w(TAG, "API failed: code=${response.code()} message=${response.message()}")
                        if (attempt > maxRetries) {
                            Toast.makeText(this@TeamActivity, "Gagal memuat data (${response.code()})", Toast.LENGTH_LONG).show()
                        } else {
                            delay(1000L * attempt)
                        }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Exception fetching teams", e)
                    if (attempt > maxRetries) {
                        Toast.makeText(this@TeamActivity, "Terjadi kesalahan: ${e.message}", Toast.LENGTH_LONG).show()
                    } else {
                        delay(1000L * attempt)
                    }
                }
            }
        }
    }

    private fun setupRecyclerView(squad: List<Player>) {
        binding.rvPlayers.layoutManager = LinearLayoutManager(this)
        val adapter = TeamAdapter(this, squad) { player ->
            showPlayerDetail(player)
        }
        binding.rvPlayers.adapter = adapter
    }

    private fun showPlayerDetail(player: Player) {
        val fragment = TeamDetailFragment.newInstance(player)
        fragment.show(supportFragmentManager, "team_detail")
    }
}