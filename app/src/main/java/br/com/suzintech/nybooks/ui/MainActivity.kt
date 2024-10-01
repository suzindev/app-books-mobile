package br.com.suzintech.nybooks.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.suzintech.nybooks.R
import br.com.suzintech.nybooks.data.repository.BooksApiDataSource
import br.com.suzintech.nybooks.databinding.ActivityMainBinding
import br.com.suzintech.nybooks.ui.adapter.BooksAdapter

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar(R.string.app_name)

        val viewModel: BooksViewModel = BooksViewModel.ViewModelFactory(BooksApiDataSource())
            .create(BooksViewModel::class.java)

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

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->
                binding.listViewFlipper.displayedChild = viewFlipper.first
                viewFlipper.second?.let { errorMessage ->
                    binding.listError.text = getString(errorMessage)
                }
            }
        })

        viewModel.getBooks()
    }
}