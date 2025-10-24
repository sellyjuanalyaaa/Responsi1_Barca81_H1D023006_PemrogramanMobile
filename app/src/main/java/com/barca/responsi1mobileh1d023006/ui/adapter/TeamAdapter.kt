package com.barca.responsi1mobileh1d023006.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.barca.responsi1mobileh1d023006.R
import com.barca.responsi1mobileh1d023006.data.model.Player
import com.barca.responsi1mobileh1d023006.databinding.ItemPlayerBinding
import com.barca.responsi1mobileh1d023006.utils.Constants

class TeamAdapter(
    private val context: Context,
    private val players: List<Player>,
    private val listener: (Player) -> Unit
) : RecyclerView.Adapter<TeamAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.bind(player, context, listener)
    }

    override fun getItemCount(): Int = players.size

    class PlayerViewHolder(private val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player, context: Context, listener: (Player) -> Unit) {
            binding.tvPlayerName.text = player.name
            binding.tvPlayerPosition.text = player.position

            val colorResId = getPositionColor(player.position)
            binding.cardPlayer.setCardBackgroundColor(ContextCompat.getColor(context, colorResId))

            binding.root.setOnClickListener { listener(player) }
        }

        private fun getPositionColor(position: String?): Int {
            return when {
                Constants.GOALKEEPER_POSITIONS.contains(position) -> R.color.barca_yellow
                Constants.DEFENDER_POSITIONS.contains(position) -> R.color.barca_blue
                Constants.MIDFIELDER_POSITIONS.contains(position) -> R.color.green
                Constants.FORWARD_POSITIONS.contains(position) -> R.color.red
                else -> R.color.white
            }
        }
    }
}