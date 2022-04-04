package com.burningfriday.getyourpokemon.modern.di

import com.burningfriday.getyourpokemon.network.api.ApiConstant
import com.burningfriday.getyourpokemon.network.api.request.PokemonService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
abstract class NetworkModule {

    companion object {
        @Provides
        @ViewModelScoped
        fun provideRetrofit(): PokemonService {
            return Retrofit.Builder()
                .baseUrl(ApiConstant.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(PokemonService::class.java)

        }
    }
}