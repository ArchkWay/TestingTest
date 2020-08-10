package com.example.testingtest.main

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.example.testingtest.data.db.PostDBWrapper

interface MainContractPresenter<V> {
    fun delegateTools(mpvView: V, fragmentActivity: FragmentActivity, owner: LifecycleOwner)
    fun attachPosts(mvpView: V, orderedBy: String, count: Int, cursor: String)
    fun getFromDB(mvpView: V)
    fun addItemToDb(mvpView: V, listOfPosts: List<PostDBWrapper>)
    fun deleteItemFromDB(postDBWrapper: PostDBWrapper)




    fun detachView()
}