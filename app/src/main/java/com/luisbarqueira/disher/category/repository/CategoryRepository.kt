package com.luisbarqueira.disher.category.repository

import com.luisbarqueira.disher.category.model.Category
import com.luisbarqueira.disher.category.model.CategoryResponse
import com.luisbarqueira.disher.category.service.ICategoryService
import javax.inject.Inject

// one repository per screen? Yes

// this is for testing and for extension!!!
interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse

}


// Implementation version of above interface
class CategoryRepository @Inject constructor(
    val service: ICategoryService
) : ICategoryRepository {
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getAllCategories()
    }
}