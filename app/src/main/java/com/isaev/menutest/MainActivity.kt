package com.isaev.menutest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.isaev.menutest.ui.theme.MenuTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MenuTestTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.tree_bg),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxWidth()
                        )
                        MenuItem(
                            name = stringResource(R.string.settings),
                            icon = painterResource(R.drawable.ic_settings)
                        )
                        MenuItem(
                            name = stringResource(R.string.tarifes),
                            icon = painterResource(R.drawable.ic_shopping_bag)
                        )
                        MenuItem(
                            name = stringResource(R.string.help),
                            icon = painterResource(R.drawable.ic_question)
                        )
                        MenuItem(
                            name = stringResource(R.string.about_app),
                            icon = painterResource(R.drawable.ic_info)
                        )
                        MenuItem(
                            name = stringResource(R.string.privacy_policy),
                            icon = painterResource(R.drawable.ic_lock_open)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MenuItem(name: String, icon: Painter) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = name,
            tint = Color.Unspecified
        )
        Spacer(Modifier.width(16.dp))
        Text(text = name)
    }
}
