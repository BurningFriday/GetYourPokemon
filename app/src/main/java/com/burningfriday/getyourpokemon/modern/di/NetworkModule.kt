package com.burningfriday.getyourpokemon.modern.di

import com.burningfriday.getyourpokemon.modern.data.repository.PokemonRepository
import com.burningfriday.getyourpokemon.modern.data.repository.impl.PokemonRepositoryImpl
import com.burningfriday.getyourpokemon.modern.data.service.PokemonService
import com.burningfriday.getyourpokemon.network.api.ApiConstant
import com.google.gson.GsonBuilder
import dagger.Binds
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

    @Binds
    @ViewModelScoped
    abstract fun bindPokemonRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository

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