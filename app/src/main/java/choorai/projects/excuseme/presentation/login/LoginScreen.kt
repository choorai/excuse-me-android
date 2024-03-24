package choorai.projects.excuseme.presentation.login

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import choorai.projects.excuseme.R
import choorai.projects.excuseme.Screen
import choorai.projects.excuseme.ui.theme.primaryColor
import choorai.projects.excuseme.ui.theme.secondaryColor

@Composable
fun LoginScreen(navController: NavHostController) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            TopSection()
            InputSection(navController)
            SocialLoginSection()
        }
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.33f),
        contentAlignment = Alignment.TopCenter
    ) {
        // background image => 우리는 필요 없음
//        Image(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(fraction = 0.46f),
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds
//        )

        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // TODO: 테스트용 로고. 향후 에셋 받으면 변경되어야 함
            Icon(
                painter = painterResource(id = R.drawable.ic_splash_test), // => Ka[]ar
                contentDescription = stringResource(id = R.string.app_name),
                tint = uiColor
            )

//            Spacer(modifier = Modifier.width(15.dp))
//            Column {
//                Text(
//                    text = stringResource(id = R.string.test_name1),
//                    style = MaterialTheme.typography.headlineMedium,
//                    color = uiColor
//                )
//                Text(
//                    text = stringResource(id = R.string.test_name2),
//                    style = MaterialTheme.typography.titleMedium,
//                    color = uiColor
//                )
//            }

        }

        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.app_name_kr),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun InputSection(navController: NavHostController) {
    val idTextState = remember { mutableStateOf("") }
    val passwordTextState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
    ) {
        // TODO : 입력란 클릭 시 화면을 살짝 올라가도록 변경해야함 (로그인 버튼이 자판에 가려지지 않도록 하기 위함)
        // TODO : 화면 클릭 시 자판 내려가는 처리 필요
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = idTextState.value,
            singleLine = true,
            onValueChange = { idTextValue -> idTextState.value = idTextValue },
            label = { Text(text = "아이디") },
            textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFC4C4C4),
                focusedBorderColor = secondaryColor
            ),
        )

        Spacer(modifier = Modifier.padding(bottom = 4.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = passwordTextState.value,
            singleLine = true,
            onValueChange = { passwordTextValue -> passwordTextState.value = passwordTextValue },
            label = { Text(text = "비밀번호") },
            textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFC4C4C4),
                focusedBorderColor = secondaryColor
            ),
            visualTransformation = PasswordVisualTransformation(),
        )

        // TODO : 나중에 기능도 같이 구현 필요. 현재는 그냥 UI만 구현
        RememberMeRadioButton()

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 55.dp),
            onClick = { /* TODO : 향후 버튼 클릭 시 로그인 처리 필요 */ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = Color.White,
                disabledContainerColor = Color.DarkGray,
                disabledContentColor = secondaryColor
            )
        ) {
            Text(
                text = "로그인",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // TODO : 향후 페이지 이동을 위한 처리 OR 해당 처리가 안된다면 button 객체로 바꿀 필요 존재
            Button(onClick = { navController.navigate(Screen.SignUp.route) }) {
                Text(
                    text = "회원가입",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
            Text(text = "|")
            Text(
                text = "아이디/비밀번호 찾기",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            )
        }
    }
}

@Composable
private fun SocialLoginSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        SocialLoginButton(
            borderColor = Color(0xFFFEE500),
            socialLoginText = "카카오톡 계정으로 로그인",
            logoImage = painterResource(
                id = R.drawable.kakaotalk_logo
            )
        )
        SocialLoginButton(
            borderColor = Color(0xFF2DB400),
            socialLoginText = "네이버 계정으로 로그인",
            logoImage = painterResource(
                id = R.drawable.naver_logo
            )
        )
        SocialLoginButton(
            borderColor = Color(0xFFABABAB),
            socialLoginText = "구글 계정으로 로그인",
            logoImage = painterResource(
                id = R.drawable.google_logo
            )
        )
    }
}

@Composable
private fun SocialLoginButton(
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Black,
    socialLoginText: String = "로그인을 해주세요",
    logoImage: Painter
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 4.dp, bottom = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        border = BorderStroke(2.dp, borderColor),
        shape = RoundedCornerShape(18),
    ) {
        Image(
            painter = logoImage,
            contentDescription = "icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(32.dp)
                .padding(start = 0.dp)
                .clip(shape = RoundedCornerShape(28)),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = socialLoginText, color = Color(0xFF707070), fontSize = 18.sp)
        }
    }
}

@Composable
private fun RememberMeRadioButton() {
    val selectedOption = remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(top = 5.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedOption.value,
                onClick = { selectedOption.value = !selectedOption.value }
            )
            Text(
                text = "로그인 상태 유지",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
