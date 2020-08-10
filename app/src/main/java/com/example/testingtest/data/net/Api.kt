package com.example.testingtest.data.net

import com.example.testingtest.domain.enteties.PostResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
        @GET("/fs-posts/v1/posts")
        fun getPosts(@Query("first") count: String, @Query("orderBy") sortType: String, @Query("after") after:String): Single<PostResponse>

}

