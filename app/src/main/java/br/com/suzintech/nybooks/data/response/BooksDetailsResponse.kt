package br.com.suzintech.nybooks.data.response

import com.google.gson.annotations.SerializedName

data class BooksDetailsResponse(
    @SerializedName("title")
    val title: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("description")
    val description: String
)
