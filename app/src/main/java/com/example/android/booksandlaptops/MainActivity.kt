package com.example.android.booksandlaptops

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    @android.annotation.SuppressLint("MissingInflatedId")
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val productList = generateProductList()
        val adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter
    }

    private fun generateProductList(): List<ProductItem> {
        val books = listOf(
            ProductItem("Book 1", "Book"),
            ProductItem("Book 2", "Book"),
            ProductItem("Book 3", "Book")
        )
        val laptops = listOf(
            ProductItem("Laptop 1","Laptop"),
            ProductItem("Laptop 2", "Laptop"),
            ProductItem("Laptop 3", "Laptop")
        )

        return books.zip(laptops).flatMap { (book, laptop) -> listOf(book, laptop) }
    }
}
