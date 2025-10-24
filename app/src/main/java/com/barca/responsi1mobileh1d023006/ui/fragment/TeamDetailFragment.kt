package com.barca.responsi1mobileh1d023006.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.barca.responsi1mobileh1d023006.data.model.Player
import com.barca.responsi1mobileh1d023006.databinding.FragmentTeamDetailBinding
import java.io.Serializable
import android.app.Dialog // <-- PENTING: Import untuk Dialog

class TeamDetailFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentTeamDetailBinding? = null
    private val binding get() = _binding!!

    // PERBAIKAN: OVERRIDE INI UNTUK MEMASTIKAN FRAGMENT BISA DITUTUP SAAT KLIK DI LUAR
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        // Mengatur agar dialog dapat ditutup dengan mengetuk di luar area Bottom Sheet
        dialog.setCanceledOnTouchOutside(true)

        // Mengatur agar dialog dapat ditutup dengan tombol Back (standar BottomSheetDialogFragment)
        isCancelable = true

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data casting tetap sama
        val player = arguments?.getSerializable(ARG_PLAYER) as? Player

        player?.let {
            binding.tvDetailName.text = it.name
            binding.tvDetailPosition.text = "Posisi: ${it.position}"
            binding.tvDetailDob.text = "Tanggal Lahir: ${it.dateOfBirth}"
            binding.tvDetailNationality.text = "Kebangsaan: ${it.nationality}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_PLAYER = "player_object"

        fun newInstance(player: Player): TeamDetailFragment {
            val fragment = TeamDetailFragment()
            val args = Bundle()
            args.putSerializable(ARG_PLAYER, player as Serializable)
            fragment.arguments = args
            return fragment
        }
    }
}