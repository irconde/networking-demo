package gal.uvigo.networking_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import gal.uvigo.networking_example.ui.SearchScreen
import gal.uvigo.networking_example.ui.theme.NetworkingExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetworkingExampleTheme {
                SearchScreen()
            }
        }
    }
}
