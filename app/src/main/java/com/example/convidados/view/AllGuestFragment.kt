package com.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.ViewModel.AllGuestViewModel
import com.example.convidados.databinding.FragmentAllGuestsBinding
import com.example.convidados.view.adapter.GuestAdapter

class AllGuestFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null

    private val binding get() = _binding!!

    private val adapter = GuestAdapter()

    private lateinit var viewModel: AllGuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        b: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this).get(AllGuestViewModel::class.java)

        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)
        //definir layout
        binding.recyclerAllGuests.layoutManager = LinearLayoutManager(context)

        binding.recyclerAllGuests.adapter = adapter
        viewModel.getAll()

        observe()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe(){
        viewModel.guests.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)

        }
    }
}