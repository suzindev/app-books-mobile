package br.com.suzintech.nybooks.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.suzintech.nybooks.R
import br.com.suzintech.nybooks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = getString(R.string.app_name)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}