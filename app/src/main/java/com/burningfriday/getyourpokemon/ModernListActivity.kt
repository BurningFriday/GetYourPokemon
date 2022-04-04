package com.burningfriday.getyourpokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.android.getyourpokemon.R
import com.android.getyourpokemon.databinding.ActivityModernListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ModernListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModernListBinding
    private val viewModel: ModernListViewModel by viewModels()
    private val listAdapter by lazy {
        ModernListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_modern_list)
        binding.run {
            viewModel = viewModel
            adapter = listAdapter
        }

        lifecycleScope.launchWhenStarted {
            viewModel.fetchPokemonList(10, 10)
        }

        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.event.collect {
                // do something
            }
        }

        lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pokemonList.collect {
                    // collect Response
                    listAdapter.submitList(it)
                }
            }
        }
    }
}