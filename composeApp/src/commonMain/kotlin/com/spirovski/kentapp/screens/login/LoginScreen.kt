package com.spirovski.kentapp.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spirovski.kentapp.components.ButtonMeals
import com.spirovski.kentapp.components.KentTopAppBar
import com.spirovski.kentapp.components.UniTextField
import com.spirovski.kentapp.navigation.Routes
import com.spirovski.kentapp.navigation.navigateToScreen
import kentapp.composeapp.generated.resources.Res
import kentapp.composeapp.generated.resources.fitness_logo

@Composable
@Preview
fun LoginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }



    Scaffold(
        topBar = { KentTopAppBar(logo = Res.drawable.fitness_logo) }
    ) {

        Column(modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            UniTextField(value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 12.dp)
            )

            UniTextField(value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                )

            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 12.dp)) {

                Text(text = "Forgot Password")
                Text(text = "Save Password")

            }

            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            if (showDialog) {

                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Missing Information") },
                    text = { Text(dialogMessage) },
                    confirmButton = {
                        ButtonMeals(text = "Ok", onClick = { showDialog = false })
                    }
                )

            }

            ButtonMeals(text = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 70.dp, vertical = 6.dp),
                onClick = {
                    if (email.isEmpty() || password.isEmpty()) {
                        showDialog = true
                        dialogMessage = "Please fill all fields"
                    } else {
                        navigateToScreen(Routes.Home)
                    }
                })

            ButtonMeals(text = "Create New Account",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 70.dp),
                onClick = {
                    navigateToScreen(Routes.Register)
                })

        }

    }

}