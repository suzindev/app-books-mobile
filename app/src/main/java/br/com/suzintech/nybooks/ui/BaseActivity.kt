package br.com.suzintech.nybooks.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import br.com.suzintech.nybooks.R

open class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(titleId: Int, showBackButton: Boolean = false) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = getString(titleId)

        setSupportActionBar(toolbar)

        if (showBackButton) supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}