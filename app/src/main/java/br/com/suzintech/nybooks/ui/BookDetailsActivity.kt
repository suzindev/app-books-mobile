package br.com.suzintech.nybooks.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.suzintech.nybooks.R
import br.com.suzintech.nybooks.databinding.ActivityBookDetailsBinding

class BookDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar(R.string.app_name, true)

        binding.bookDetailTextTitle.text = intent.getStringExtra(EXTRA_TITLE)
        binding.bookDetailTextDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String): Intent {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}