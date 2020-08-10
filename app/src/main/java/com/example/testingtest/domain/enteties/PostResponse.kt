package com.example.testingtest.domain.enteties

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("data")
    val `data`: Data? = null,
    @SerializedName("errors")
    val errors: Any? = null
)

data class Comments(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("my")
    val my: Boolean? = null
)

data class Size(
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null
)

data class ExtraSmallXX(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("size")
    val size: SizeXXXX? = null
)

data class Author(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("banner")
    val banner: Banner? = null,
    @SerializedName("photo")
    val photo: Photo? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("isHidden")
    val isHidden: Boolean? = null,
    @SerializedName("isBlocked")
    val isBlocked: Boolean? = null,
    @SerializedName("isMessagingAllowed")
    val isMessagingAllowed: Boolean? = null,
    @SerializedName("auth")
    val auth: Auth? = null,
    @SerializedName("tagline")
    val tagline: String? = null,
    @SerializedName("data")
    val `data`: DataXXXX? = null
)

data class Shares(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("my")
    val my: Boolean? = null
)

data class ExtraSmallX(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("size")
    val size: SizeXX? = null
)

class DataXXXX(
)

data class Replies(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("my")
    val my: Boolean? = null
)

data class Item(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("replyOnPostId")
    val replyOnPostId: Any? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("hidingReason")
    val hidingReason: String? = null,
    @SerializedName("coordinates")
    val coordinates: Coordinates? = null,
    @SerializedName("isCommentable")
    val isCommentable: Boolean? = null,
    @SerializedName("hasAdultContent")
    val hasAdultContent: Boolean? = null,
    @SerializedName("isAuthorHidden")
    val isAuthorHidden: Boolean? = null,
    @SerializedName("isHiddenInProfile")
    val isHiddenInProfile: Boolean? = null,
    @SerializedName("contents")
    val contents: List<Content>? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("awards")
    val awards: Awards? = null,
    @SerializedName("createdAt")
    val createdAt: Long? = null,
    @SerializedName("updatedAt")
    val updatedAt: Long? = null,
    @SerializedName("page")
    val page: Any? = null,
    @SerializedName("author")
    val author: Author? = null,
    @SerializedName("stats")
    val stats: Stats? = null,
    @SerializedName("isMyFavorite")
    val isMyFavorite: Boolean? = null
)

data class SizeXXXXX(
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null
)

data class OriginalX(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("size")
    val size: SizeXXXXX? = null
)

data class Content(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("data")
    val `data`: DataX? = null,
    @SerializedName("id")
    val id: String? = null
)

data class SizeXXX(
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null
)

data class Data(
    @SerializedName("items")
    val items: List<Item>? = null,
    @SerializedName("cursor")
    val cursor: String? = null
)

data class ExtraSmall(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("size")
    val size: Size? = null
)

data class Stats(
    @SerializedName("likes")
    val likes: Likes? = null,
    @SerializedName("views")
    val views: Views? = null,
    @SerializedName("comments")
    val comments: Comments? = null,
    @SerializedName("shares")
    val shares: Shares? = null,
    @SerializedName("replies")
    val replies: Replies? = null,
    @SerializedName("timeLeftToSpace")
    val timeLeftToSpace: TimeLeftToSpace? = null
)

data class Photo(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("data")
    val `data`: DataXXX? = null
)

data class Banner(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("data")
    val `data`: DataXX? = null
)

data class SizeX(
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null
)

data class Likes(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("my")
    val my: Boolean? = null
)

data class Coordinates(
    @SerializedName("latitude")
    val latitude: Double? = null,
    @SerializedName("longitude")
    val longitude: Double? = null,
    @SerializedName("zoom")
    val zoom: Any? = null
)

data class SizeXXXX(
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null
)

data class Small(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("size")
    val size: SizeX? = null
)

data class DataX(
    @SerializedName("value")
    val value: String? = null,
    @SerializedName("extraSmall")
    val extraSmall: ExtraSmall? = null,
    @SerializedName("small")
    val small: Small? = null,
    @SerializedName("values")
    val values: List<String>? = null
)

data class Awards(
    @SerializedName("recent")
    val recent: List<Any>? = null,
    @SerializedName("statistics")
    val statistics: List<Any>? = null,
    @SerializedName("voices")
    val voices: Int? = null,
    @SerializedName("awardedByMe")
    val awardedByMe: Boolean? = null
)

data class TimeLeftToSpace(
    @SerializedName("count")
    val count: Any? = null,
    @SerializedName("my")
    val my: Boolean? = null
)

data class DataXXX(
    @SerializedName("extraSmall")
    val extraSmall: ExtraSmallXX? = null,
    @SerializedName("original")
    val original: OriginalX? = null
)

data class SizeXX(
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null
)

data class Views(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("my")
    val my: Boolean? = null
)

data class DataXX(
    @SerializedName("extraSmall")
    val extraSmall: ExtraSmallX? = null,
    @SerializedName("original")
    val original: Original? = null
)

data class Original(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("size")
    val size: SizeXXX? = null
)

data class Auth(
    @SerializedName("rocketId")
    val rocketId: String? = null,
    @SerializedName("isDisabled")
    val isDisabled: Boolean? = null,
    @SerializedName("level")
    val level: Int? = null
)