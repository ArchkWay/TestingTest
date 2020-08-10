package com.example.testingtest.main

import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.testingtest.common.BaseApp
import com.example.testingtest.data.db.PostDBWrapper
import com.example.testingtest.domain.Constants
import com.example.testingtest.domain.enteties.PostResponse
import com.example.testingtest.main.MainContract.*
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.time.LocalDateTime
import javax.inject.Inject

class MainPresenter @Inject constructor(context: Context) : Presenter {

    var disposable: ArrayList<Disposable> = arrayListOf()
    private var view: View? = null

    @Inject
    lateinit var model: Model

    init {
        BaseApp[context].injector?.inject(this)
    }

    override fun delegateTools(
        mpvView: View?,
        fragmentActivity: FragmentActivity,
        owner: LifecycleOwner
    ) {
        this.view = mpvView
        model.getTools(fragmentActivity, owner)
    }


    override fun attachPosts(mvpView: View?, orderedBy: String, count: Int, cursor: String) {
        this.view = mvpView
        disposable.plusAssign(
            model.getPosts(count.toString(), orderedBy, cursor).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe { postResponse ->
                    view?.cursor = postResponse.data?.cursor ?: ""
                view?.setPosts(generateItems(postResponse))
            })
    }

    override fun getFromDB(mvpView: View?) {
        this.view = mvpView
        model.getViewModel().allPosts.observe(model.getLCOwner(), Observer { posts ->
            view?.setPosts(posts)
            model.getViewModel().allPosts.removeObservers(model.getLCOwner())
        })
    }

    override fun addItemToDb(mvpView: View?, listOfPosts: List<PostDBWrapper>) {
        listOfPosts.forEach {
            disposable.plusAssign(
                Single.just(model.addInDb(listOf(it))).subscribeOn(Schedulers.computation()).onErrorReturn { listOf<PostDBWrapper>() }.doOnError { Log.d(Constants.ERROR, it.message )  }.subscribe()
            )
        }
    }

    override fun deleteItemFromDB(postDBWrapper: PostDBWrapper) {
        model.delete(postDBWrapper)
    }

    private fun generateItems(postResponse: PostResponse): List<PostDBWrapper> {
        val list: ArrayList<PostDBWrapper> = arrayListOf()
        var id = LocalDateTime.now().nano
        postResponse.data?.items?.forEach {
            list += PostDBWrapper(id, it.author?.name ?: "", it.contents?.firstOrNull()?.data?.value ?: "", it.contents?.firstOrNull()?.data?.small?.url ?: "" )
            id++
        }
        return list
    }

    override fun detachView() {
        disposable.forEach { it.dispose() }
    }



}