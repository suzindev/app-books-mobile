package br.com.suzintech.nybooks.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.suzintech.nybooks.R
import br.com.suzintech.nybooks.data.model.Book

class BooksAdapter(
    private val lista: List<Book>
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.item_book_textTitle)
        private val author = itemView.findViewById<TextView>(R.id.item_book_textAuthor)

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)

        return BooksViewHolder(view)
    }

    override fun getItemCount() = lista.count()

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(lista[position])
    }
}