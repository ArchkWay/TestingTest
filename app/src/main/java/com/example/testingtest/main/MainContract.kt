package com.example.testingtest.main

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.example.testingtest.data.db.PostDBWrapper
import com.example.testingtest.data.db.PostViewModel
import com.example.testingtest.domain.enteties.PostResponse
import io.reactivex.Observable
import io.reactivex.Single
import java.io.StringReader

interface MainContract {
    interface View {
        fun setPosts(posts: List<PostDBWrapper>)
        var cursor: String
    }

    interface Presenter : MainContractPresenter<View?>

    interface Model {
        fun getTools(fragmentActivity: FragmentActivity, owner: LifecycleOwner)
        fun getViewModel(): PostViewModel
        fun getLCOwner(): LifecycleOwner
        fun getPosts (count: String, orderedBy: String, after: String): Single<PostResponse>
        fun getDBPost(): List<PostDBWrapper>?
        fun addInDb (listOfPosts: List<PostDBWrapper>)
        fun delete(postDBWrapper: PostDBWrapper)

    }
}