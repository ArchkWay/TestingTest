package com.example.testingtest.data.db

import androidx.lifecycle.LiveData

class PostRepository(private val postDao: PostDao) {

    val allPosts: LiveData<List<PostDBWrapper>> = postDao.fetchAll()

    suspend fun insert(arg: PostDBWrapper) {
        postDao.insert(arg)
    }

    suspend fun update(arg: PostDBWrapper) {
        postDao.update(arg)
    }

    suspend fun delete(arg: PostDBWrapper) {
        postDao.delete(arg)
    }
}
