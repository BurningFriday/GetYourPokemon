package com.burningfriday.getyourpokemon.common.di

import com.burningfriday.getyourpokemon.common.provider.ToastProvider
import com.burningfriday.getyourpokemon.common.provider.ToastProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author JungHoon Park
 * @description 공통으로 사용할 수 있는 기능들 주입하여 사용
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class ProviderModule {

    @Binds
    abstract fun bindToastProvider(
        toastProviderImpl: ToastProviderImpl
    ): ToastProvider

}