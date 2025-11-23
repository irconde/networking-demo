package gal.uvigo.networking_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gal.uvigo.networking_example.ui.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SearchFragment())
            .commitNow()
    }
}