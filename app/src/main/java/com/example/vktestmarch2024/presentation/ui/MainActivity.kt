package com.example.vktestmarch2024.presentation.ui

import androidx.activity.viewModels
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vktestmarch2024.R
import com.example.vktestmarch2024.databinding.ActivityMainBinding
import com.example.vktestmarch2024.presentation.adapter.ProductsListAdapter
import com.example.vktestmarch2024.presentation.viewmodel.ProductsListViewModel
import com.example.vktestmarch2024.utils.Common
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startFragment()
    }

    private fun startFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, ProductsListFragment(), "ProductsListFragment")
            .commit()
    }
}