package choorai.projects.excuseme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import choorai.projects.excuseme.app.ExcuseMeApp
import choorai.projects.excuseme.ui.theme.ExcuseMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ExcuseMeTheme {
                ExcuseMeApp()
            }
        }
    }
}
