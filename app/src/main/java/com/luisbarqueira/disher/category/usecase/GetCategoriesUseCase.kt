package com.luisbarqueira.disher.category.usecase

import com.luisbarqueira.disher.category.model.CategoryResponse
import com.luisbarqueira.disher.category.repository.ICategoryRepository
import javax.inject.Inject


// interface for future testing
interface IGetCategoriesUseCase {
    // invoke function
    suspend operator fun invoke(): CategoryResponse


}


// Hilt is passing an repo interface, how to implement and which implementation I want?

class GetCategoriesUseCase @Inject constructor(
    val repo: ICategoryRepository
) : IGetCategoriesUseCase {
    override suspend fun invoke(): CategoryResponse {
        // invoke talking to repository
        return repo.getAllCategories()
    }

}