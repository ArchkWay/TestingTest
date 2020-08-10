package com.example.testingtest.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testingtest.common.BaseApp
import com.example.testingtest.DescriptionActivity
import com.example.testingtest.R
import com.example.testingtest.data.db.PostParcel
import com.example.testingtest.data.db.PostDBWrapper
import com.example.testingtest.data.net.Api
import com.example.testingtest.data.net.RetrofitProvider
import com.example.testingtest.domain.ConnectivityHelper
import com.example.testingtest.domain.Constants
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), PostAdapter.TouchEvent, MainContract.View, PaginationCallBack {

    @Inject
    lateinit var presenter: MainContract.Presenter

    private lateinit var postAdapter: PostAdapter
    private var orderType = Constants.MOSTPOPULAR
    private var quantityPosts = 20
    private var countPushes = 0
    override var cursor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BaseApp[this].injector?.inject(this)
        presenter.delegateTools(this, this, this)
        if (ConnectivityHelper.isConnectedToNetwork(this)) presenter.attachPosts(this, orderType, quantityPosts, cursor)
        else presenter.getFromDB(this)
        postAdapter = PostAdapter(this, this, this)

        rvContainer.adapter = postAdapter
        rvContainer.layoutManager = LinearLayoutManager(this)
        btnOrderType.text = orderType
        btnOrderType.setOnClickListener {
            if (ConnectivityHelper.isConnectedToNetwork(this)) orderTypeChange()
            else Toast.makeText(this, Constants.CONNECTING_ERROR, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(item: PostDBWrapper) {
        val intent = Intent(this, DescriptionActivity().javaClass)
        intent.putExtra(
            Constants.POST_SAVE,
            PostParcel(item.author, item.description, item.url)
        )
        startActivity(intent)
    }


    private fun orderTypeChange() {
        when (countPushes) {
            0 -> changeOrderTypeView(Constants.MOSTCOMMENTED)
            1 -> changeOrderTypeView(Constants.CREATEDAT)
            2 -> changeOrderTypeView(Constants.MOSTPOPULAR)
        }
    }

    private fun changeOrderTypeView(text: String) {
        btnOrderType.text = text.also {
            presenter.attachPosts(this, text, quantityPosts, cursor)
            countPushes++
            if(countPushes > 2) countPushes = 0
        }
    }


    override fun setPosts(posts: List<PostDBWrapper>) {
        posts.forEach {
            postAdapter.addItem(it)
        }
        if(ConnectivityHelper.isConnectedToNetwork(this)) {
            presenter.addItemToDb(this, posts)
        }
    }
    override fun loadNextPage() {
        presenter.attachPosts(this, orderType, quantityPosts, cursor)
    }

}

interface PaginationCallBack {
    fun loadNextPage()
}

