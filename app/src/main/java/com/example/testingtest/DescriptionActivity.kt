package com.example.testingtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.testingtest.data.db.PostParcel
import com.example.testingtest.domain.Constants
import kotlinx.android.synthetic.main.description_info.*


class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.description_info)
        val item = intent.getParcelableExtra<PostParcel>(Constants.POST_SAVE)
        with(item) {
            tvDescription.text = description
            Glide.with(this@DescriptionActivity)
                .load(item.url)
                .into(ivImage)
        }
    }
}
