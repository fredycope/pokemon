package com.example.demo.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demo.R
import com.example.demo.databinding.FragmentDetailBinding
import com.example.demo.ui.adapters.PokemonAdapter
import com.example.demo.ui.adapters.PokemonDetailAdapter
import com.example.demo.ui.viewmodels.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var url: String
    lateinit var listAdapter: PokemonDetailAdapter

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            url = it?.get("obj").toString()
        }
        listAdapter = PokemonDetailAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.rvPokemonDetail.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvPokemonDetail.adapter = listAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPokemonDetail(url)
        viewModel.pokemonDetail.observe(viewLifecycleOwner, Observer {
            listAdapter.addData(it)
        })
    }

}