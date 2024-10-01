package br.com.suzintech.nybooks.data.repository

import br.com.suzintech.nybooks.data.BooksResult

interface BooksRepository {

    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)
}