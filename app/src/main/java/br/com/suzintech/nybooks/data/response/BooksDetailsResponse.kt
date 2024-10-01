package br.com.suzintech.nybooks.data.response

import br.com.suzintech.nybooks.data.model.Book
import com.google.gson.annotations.SerializedName

data class BooksDetailsResponse(
    @SerializedName("title")
    val title: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("description")
    val description: String
) {
    fun getBookModel() = Book(
        title = this.title,
        author = this.author,
        description = this.description
    )
}
