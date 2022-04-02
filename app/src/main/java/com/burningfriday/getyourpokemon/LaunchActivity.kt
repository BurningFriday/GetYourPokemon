package com.burningfriday.getyourpokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.android.getyourpokemon.R
import com.android.getyourpokemon.databinding.ActivityLaunchBinding

/**
 * @author Hyunwoo Choi
 */
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
        viewModel.event.observe(this) { eventWrapper ->
            val event = eventWrapper.peekContent() as? LaunchEvent ?: return@observe
            when(event) {
                LaunchEvent.OnClickSampleAAC -> {
                    startActivity(Intent(this, ModernListActivity::class.java))
                }

                LaunchEvent.OnClickSampleCompose -> {
                    startActivity(Intent(this, ComposeListActivity::class.java))
                }
            }
        }
    }

}