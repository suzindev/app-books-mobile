package br.com.suzintech.nybooks.data.response

import com.google.gson.annotations.SerializedName

data class BookResultsResponse(
    @SerializedName("book_details")
    val booksDetailsResponse: List<BooksDetailsResponse>
)
