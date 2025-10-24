package com.barca.responsi1mobileh1d023006

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.barca.responsi1mobileh1d023006.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
        }
    private fun initLayout(){
        binding.LayoutHistory.let {
            it.imgIcon.setImageResource(R.drawable.ic_football)
            it.tvLayout.setText(R.string.history)
        }
        binding.LayoutCoach.let {
            it.imgIcon.setImageResource(R.drawable.ic_official)
            it.tvLayout.setText(R.string.ofc)
        }
        binding.LayoutPlayer.let {
            it.imgIcon.setImageResource(R.drawable.ic_team)
            it.tvLayout.setText(R.string.teams)
        }
    }
    private fun initListener(){
        binding.LayoutHistory.root.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
        binding.LayoutCoach.root.setOnClickListener {
           val intent = Intent(this, CoachActivity::class.java)
            startActivity(intent)
        }
        binding.LayoutPlayer.root.setOnClickListener {
            val intent = Intent(this, TeamActivity::class.java)
            startActivity(intent)
        }
    }

}