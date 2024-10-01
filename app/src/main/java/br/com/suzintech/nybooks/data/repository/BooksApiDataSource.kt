package br.com.suzintech.nybooks.data.repository

import br.com.suzintech.nybooks.data.BooksResult
import br.com.suzintech.nybooks.data.model.Book
import br.com.suzintech.nybooks.data.response.BookBodyResponse
import br.com.suzintech.nybooks.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksApiDataSource : BooksRepository {

    override fun getBooks(booksResultCallback: (result: BooksResult) -> Unit) {
        ApiClient.service.getBooks()
            .enqueue(object : Callback<BookBodyResponse> {
                override fun onResponse(
                    call: Call<BookBodyResponse>,
                    response: Response<BookBodyResponse>
                ) {
                    when {
                        response.isSuccessful -> {
                            val books: MutableList<Book> = mutableListOf()

                            response.body()?.let { bookResponse ->
                                for (result in bookResponse.bookResults) {
                                    val book = result.booksDetailsResponse[0].getBookModel()

                                    books.add(book)
                                }
                            }

                            booksResultCallback(BooksResult.Success(books))
                        }

                        else -> booksResultCallback(BooksResult.ApiError(response.code()))
                    }
                }

                override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                    booksResultCallback(BooksResult.ServerError)
                }
            })
    }
}