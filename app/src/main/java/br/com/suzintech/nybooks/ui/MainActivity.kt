package br.com.suzintech.nybooks.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.suzintech.nybooks.R
import br.com.suzintech.nybooks.databinding.ActivityMainBinding
import br.com.suzintech.nybooks.ui.adapter.BooksAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = getString(R.string.app_name)
        setSupportActionBar(findViewById(R.id.toolbar))

        val viewModel: BooksViewModel = ViewModelProvider(this)[BooksViewModel::class.java]
        viewModel.booksLiveData.observe(this, Observer {
            it?.let { books ->
                with(binding.listBooks) {
                    layoutManager =
                        LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)

                    adapter = BooksAdapter(books) { book ->
                        this@MainActivity.startActivity(
                            BookDetailsActivity.getStartIntent(
                                this@MainActivity,
                                book.title,
                                book.description
                            )
                        )
                    }
                }
            }
        })
        viewModel.getBooks()
    }
}