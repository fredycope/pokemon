package com.example.demo.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demo.R
import com.example.demo.databinding.FragmentListBinding
import com.example.demo.ui.adapters.PokemonAdapter
import com.example.demo.ui.viewmodels.ListViewModel
import com.example.demo.utils.Nav
import com.example.demo.utils.OnClickList
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment(), OnClickList {
    lateinit var binding : FragmentListBinding
    lateinit var listAdapter: PokemonAdapter
    private val viewModel: ListViewModel by viewModels()

    @Inject
    lateinit var navigation: Nav

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = PokemonAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.rvPokemon.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvPokemon.adapter = listAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPokemon()
        viewModel.pokemonInformation.observe(viewLifecycleOwner, Observer {
            listAdapter.addData(it)
        })
    }

    override fun goToFragment(result: Any, view: View) {
        val bundle = bundleOf("obj" to result.toString())
        navigation.gotoFragment(view,R.id.action_listFragment_to_detailFragment,bundle)
    }

}