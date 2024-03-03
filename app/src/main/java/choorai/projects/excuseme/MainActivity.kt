package choorai.projects.excuseme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import choorai.projects.excuseme.ui.theme.ExcuseMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExcuseMeTheme {
            }
        }
    }
}
