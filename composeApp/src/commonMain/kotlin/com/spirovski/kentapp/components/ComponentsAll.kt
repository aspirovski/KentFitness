package com.spirovski.kentapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spirovski.kentapp.navigation.Routes
import com.spirovski.kentapp.navigation.navigateBack
import com.spirovski.kentapp.navigation.navigateToScreen
import com.spirovski.kentapp.screens.TopShadow
import kentapp.composeapp.generated.resources.Res
import kentapp.composeapp.generated.resources.fitness_logo
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun UniTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    unFocusedLabelColor: Color = Color.LightGray,
    focusedLabelColor: Color = Color.Gray,
    unfocusedIndicatorColor: Color = Color.Transparent,
    focusedIndicatorColor: Color = Color.Transparent,
    unfocusedContainerColor: Color = Color.LightGray,
    focusedContainerColor: Color = Color.LightGray,
    modifier: Modifier = Modifier
) {

    // TODO: Probaj so OutlinedTextField, poubaj se

    TextField(
        value = value,
        onValueChange = onValueChange,
        minLines = 1,
        maxLines = 50,
        placeholder = { Text(placeholder) },
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedLabelColor = unFocusedLabelColor, focusedLabelColor = focusedLabelColor,
            unfocusedIndicatorColor = unfocusedIndicatorColor, focusedIndicatorColor = focusedIndicatorColor,
            unfocusedContainerColor = unfocusedContainerColor, focusedContainerColor = focusedContainerColor
        )
    )

}

@Composable
fun ButtonMeals(text: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(7.dp)
    ) {
        Text(text = text)

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KentTopAppBar(
    title: String = "",
    logo: DrawableResource? = null,
    showNavigateBack: Boolean = false
) {

    CenterAlignedTopAppBar(
        title = {
            if (logo == null) {
                Text(text = title)
            } else {
                Image(
                    painterResource(logo), contentDescription = "logo",
                    modifier = Modifier.width(200.dp).height(100.dp)
                )
            }

        },
        navigationIcon = {
            if (showNavigateBack) {
                Icon(
                    modifier = Modifier.clickable { navigateBack() },
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back button"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
        actions = {

            IconButton(onClick = {
                navigateToScreen(Routes.Profile)
            }) {

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profilna",
                    modifier = Modifier.size(32.dp)
                )

            }
        })
}

@Composable
fun KentBottomAppBar() {

    val bottomBarIcons = listOf(
        Icons.Default.Home,
        Icons.Default.AccountCircle,
        Icons.Default.Add,
        Icons.Default.Tab,
    )  // Bottom bar ikoni

    Column {
        TopShadow()
        BottomAppBar (containerColor = Color.White,
            modifier = Modifier.height(60.dp),
            tonalElevation = 8.dp) {
            Row(modifier = Modifier.fillMaxWidth()) {
                bottomBarIcons.forEach { icon ->
                    Tab(
                        onClick = {}, modifier = Modifier.weight(1f),
                        selected = true,
                    ) {
                        Icon(imageVector = icon, contentDescription = null, tint = Color.Red)
                    }
                }
            }
        }
    }
}

@Composable
fun DivideHor(thickness: Dp = 2.dp) {

    HorizontalDivider(modifier = Modifier.fillMaxWidth(),
        thickness = thickness)

}