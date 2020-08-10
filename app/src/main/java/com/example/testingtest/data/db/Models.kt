package com.example.testingtest.data.db

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Entity
data class PostDBWrapper(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    var author: String,
    var description: String,
    var url: String
) {
    override fun toString(): String {
        return "PostNote(uid=$uid, author='$author', description='$description', url='$url' )"
    }
}

@Dao
interface PostDao  {

    @Query("select * from PostDBWrapper")
    fun fetchAll(): LiveData<List<PostDBWrapper>>

    @Insert
    suspend fun insert(arg: PostDBWrapper)

    @Update
    suspend fun update(arg: PostDBWrapper)

    @Delete
    suspend fun delete(arg: PostDBWrapper)

}

@Parcelize
data class PostParcel(var author: String, var description: String, var url: String) : Parcelable



