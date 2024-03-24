package choorai.projects.excuseme.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import choorai.projects.excuseme.Screen
import choorai.projects.excuseme.presentation.login.LoginScreen
import choorai.projects.excuseme.presentation.signup.SignUpScreen

@Composable
fun ExcuseMeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Screen.Login.route) {
            composable(Screen.Login.route) { LoginScreen(navController) }
            composable(Screen.SignUp.route) { SignUpScreen(navController) }
        }
    }
}
