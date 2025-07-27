package edu.unikom.latihanparsingapipublik.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unikom.latihanparsingapipublik.network.ApiConfig
import edu.unikom.latihanparsingapipublik.network.ApiService
import edu.unikom.latihanparsingapipublik.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService = ApiConfig.getApiService()

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository =
        UserRepository(apiService)
}