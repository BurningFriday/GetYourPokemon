package com.burningfriday.getyourpokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.android.getyourpokemon.R
import com.android.getyourpokemon.databinding.ActivityModernListBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ModernListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModernListBinding
    private val viewModel: ModernListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_modern_list)
        binding.viewModel = viewModel

        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.event.collect {
                // do something
            }
        }
    }

}