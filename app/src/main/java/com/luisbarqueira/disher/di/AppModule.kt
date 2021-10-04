package com.luisbarqueira.disher.di

import com.luisbarqueira.disher.category.repository.CategoryRepository
import com.luisbarqueira.disher.category.repository.ICategoryRepository
import com.luisbarqueira.disher.category.service.ICategoryService
import com.luisbarqueira.disher.category.usecase.GetCategoriesUseCase
import com.luisbarqueira.disher.category.usecase.IGetCategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

// Hilt that`s how you make one ....
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesCategoryService(retrofit: Retrofit):ICategoryService{
        return retrofit.create(ICategoryService::class.java)
    }


    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        // I want to return a repo of type CategoryRepository when I have been asked for ICategoryRepository
        // Singleton to guarantee it will be all the app only one repo
        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository

        @Binds
        @Singleton
        fun provideCategoriesUseCase(uc: GetCategoriesUseCase): IGetCategoriesUseCase


    }


}