package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        viewBinding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.getData()
        adapter = DataAdapter(this, listOf())
        viewBinding.recycler.adapter = adapter
        lifecycleScope.launch {
            viewModel.data.collect {
                if (it.isNotEmpty()) {
                    updateData(it)
                }
            }
        }
        setContentView(viewBinding.root)
    }

    private fun updateData(list: List<String>) {
        adapter.data = list
        adapter.notifyDataSetChanged()

    }
}