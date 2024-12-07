package com.example.mobilebrowser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private val websites = listOf(
        Website("Yandex", "https://yandex.ru", R.drawable.yandex),
        Website("Gismeteo", "https://www.gismeteo.ru", R.drawable.gismeteo),
        Website("Google", "https://www.google.com", R.drawable.google),
        Website("Wikipedia", "https://www.wikipedia.org", R.drawable.wikipedia)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Настройка Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Настройка GridView
        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = WebsiteAdapter(this, websites)
        gridView.adapter = adapter

        // Обработка нажатия на элемент GridView
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", websites[position].url)
            startActivity(intent)
        }
    }

    // Создание меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Обработка нажатия на пункт меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}