package com.example.testingtest.data.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PostRepository

    val allPosts: LiveData<List<PostDBWrapper>>

    init {
        val postDao = PostDatabase.getDatabase(application).appPostDao()
        repository = PostRepository(postDao)
        allPosts = repository.allPosts
    }

    fun insert(arg: PostDBWrapper) = viewModelScope.launch {
        repository.insert(arg)
    }

    fun update(arg: PostDBWrapper) = viewModelScope.launch {
        repository.update(arg)
    }

    fun delete(arg: PostDBWrapper) = viewModelScope.launch {
        repository.delete(arg)
    }
}
