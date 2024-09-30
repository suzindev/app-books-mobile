package br.com.suzintech.nybooks.network

import br.com.suzintech.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "6WA7ZflvBiSQkioTRPArA1XfGg1eFqFz",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}