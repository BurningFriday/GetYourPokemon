package com.burningfriday.getyourpokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.android.getyourpokemon.R
import com.android.getyourpokemon.databinding.ActivityLaunchBinding
import com.burningfriday.getyourpokemon.common.Event
import com.burningfriday.getyourpokemon.modern.presenter.ModernListActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * @author Hyunwoo Choi
 */
@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchBinding
    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_launch)
        binding.viewModel = viewModel

        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.event.collect { handleEvent(it) }
        }
    }

    private fun handleEvent(event: Event) {
        when(event) {
            is LaunchEvent.OnClickSampleAAC -> {
                startActivity(Intent(this, ModernListActivity::class.java))
            }
            is LaunchEvent.OnClickSampleCompose -> {
                startActivity(Intent(this, ComposeListActivity::class.java))
            }
            else -> {}
        }
    }

}