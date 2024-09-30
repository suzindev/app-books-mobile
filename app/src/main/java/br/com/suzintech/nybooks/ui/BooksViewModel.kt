package br.com.suzintech.nybooks.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.suzintech.nybooks.data.model.Book
import br.com.suzintech.nybooks.data.response.BookBodyResponse
import br.com.suzintech.nybooks.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        ApiClient.service.getBooks()
            .enqueue(object : Callback<BookBodyResponse> {
                override fun onResponse(
                    call: Call<BookBodyResponse>,
                    response: Response<BookBodyResponse>
                ) {
                    if (response.isSuccessful) {
                        val books: MutableList<Book> = mutableListOf()

                        response.body()?.let { bookResponse ->
                            for (result in bookResponse.bookResults) {
                                val book = Book(
                                    title = result.booksDetailsResponse[0].title,
                                    author = result.booksDetailsResponse[0].author,
                                    description = result.booksDetailsResponse[0].description
                                )

                                books.add(book)
                            }
                        }

                        booksLiveData.value = books
                    }
                }

                override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }
}