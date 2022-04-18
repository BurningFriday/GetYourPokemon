package com.burningfriday.getyourpokemon.common.provider

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * @author JungHoon Park
 */
class ToastProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ToastProvider {
    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}