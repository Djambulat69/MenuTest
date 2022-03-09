package com.isaev.menutest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.isaev.menutest.ui.theme.MenuTestTheme
import com.isaev.menutest.ui.theme.Red

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MenuTestTheme {
                ProvideWindowInsets {
                    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                        Column {
                            Box(contentAlignment = Alignment.TopCenter) {
                                Image(
                                    painter = painterResource(R.drawable.tree_bg),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(176.dp)
                                )
                                Column {
                                    Spacer(Modifier.statusBarsHeight(60.dp))
                                    Text(
                                        text = stringResource(R.string.menu),
                                        style = MaterialTheme.typography.h1,
                                    )
                                }
                            }
                            Card(
                                shape = RoundedCornerShape(0.dp),
                                elevation = 14.dp,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                MenuItem(
                                    name = stringResource(R.string.settings),
                                    icon = painterResource(R.drawable.ic_settings)
                                )
                            }
                            Spacer(Modifier.height(32.dp))
                            Card(
                                shape = RoundedCornerShape(0.dp),
                                elevation = 14.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(align = Alignment.Top)
                            ) {
                                Column(modifier = Modifier.fillMaxWidth()) {


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
                            Text(
                                text = stringResource(R.string.logout),
                                style = MaterialTheme.typography.h5,
                                textAlign = TextAlign.Center,
                                color = Red,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { }
                                    .padding(vertical = 32.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MenuItem(name: String, icon: Painter) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = name,
            tint = Color.Unspecified
        )
        Spacer(Modifier.width(16.dp))
        Text(text = name, style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
    }
}
