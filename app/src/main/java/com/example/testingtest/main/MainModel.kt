package com.example.testingtest.main

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testingtest.common.BaseApp
import com.example.testingtest.data.db.PostDBWrapper
import com.example.testingtest.data.db.PostViewModel
import com.example.testingtest.data.net.Api
import com.example.testingtest.data.net.RetrofitProvider
import com.example.testingtest.domain.enteties.PostResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainModel @Inject constructor(context: Context) : MainContract.Model {
    @Inject
    lateinit var provider: RetrofitProvider
    private var api: Api
    private lateinit var postViewModel: PostViewModel
    private lateinit var activity: FragmentActivity
    private lateinit var lifeCycleOwner: LifecycleOwner
    var list: List<PostDBWrapper>? = null

    init {
        BaseApp[context].injector?.inject(this)
        api = provider.api
    }

    override fun getTools(fragmentActivity: FragmentActivity, owner: LifecycleOwner) {
        activity = fragmentActivity
        lifeCycleOwner = owner
        postViewModel = ViewModelProviders.of(fragmentActivity).get(PostViewModel::class.java)
    }

    override fun getViewModel() = postViewModel
    override fun getLCOwner() = lifeCycleOwner

    override fun getPosts(count: String, orderedBy: String, after: String): Single<PostResponse> {
        return api.getPosts(count, orderedBy, after).subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()
        ).doOnError { }.onErrorReturn { PostResponse() }
    }

    override fun getDBPost(): List<PostDBWrapper>? {
        return list
    }


    override fun addInDb(listOfPosts: List<PostDBWrapper>) {
        postViewModel.allPosts.observe(lifeCycleOwner, Observer { posts ->
            listOfPosts.forEach {
                postViewModel.insert(it)
            }
            postViewModel.allPosts.removeObservers(lifeCycleOwner)
        })
    }

    override fun delete(postDBWrapper: PostDBWrapper) {
        postViewModel.delete(postDBWrapper)
    }
}

