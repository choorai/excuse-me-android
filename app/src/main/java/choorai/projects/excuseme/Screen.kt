package choorai.projects.excuseme

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object SignUp : Screen("signUp")
}
