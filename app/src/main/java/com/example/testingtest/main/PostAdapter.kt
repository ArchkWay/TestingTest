package com.example.testingtest.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testingtest.R
import com.example.testingtest.data.db.PostDBWrapper
import kotlinx.android.synthetic.main.description_info.*
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter internal constructor(val context: Context, private val touchEvent: TouchEvent, val pageCallBack: PaginationCallBack) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    interface TouchEvent {
        fun onClick(item: PostDBWrapper)
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var objects = emptyList<PostDBWrapper>()

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = inflater.inflate(R.layout.post_item, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val current = objects[position]
        if(position + 1 == objects.size){
            pageCallBack.loadNextPage()
        }
        holder.itemView.tvPostDescription.text = current.description
        holder.itemView.tvPostAuthor.text = current.author
        Glide.with(context)
            .load(current.url)
            .into(holder.itemView.iv)
        holder.itemView.setOnClickListener {
            touchEvent.onClick(current)
        }
    }

    fun delete(postDBWrapper: PostDBWrapper){
        this.objects -= postDBWrapper
        notifyDataSetChanged()
    }

    internal fun addItem(item: PostDBWrapper) {
        this.objects += item
        notifyDataSetChanged()
    }

    override fun getItemCount() = objects.size
}
