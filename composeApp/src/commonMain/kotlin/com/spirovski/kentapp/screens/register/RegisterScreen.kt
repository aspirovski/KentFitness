package com.spirovski.kentapp.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@Composable
@Preview
fun RegisterScreen() {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = { KentTopAppBar(logo = Res.drawable.fitness_logo) }
    ) {

        Column(modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            UniTextField(value = firstName,
                onValueChange = { firstName = it },
                placeholder = "First Name",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 12.dp)
            )

            UniTextField(value = lastName,
                onValueChange = { lastName = it },
                placeholder = "Last Name",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            )

            UniTextField(value = mobileNumber,
                onValueChange = { mobileNumber = it },
                placeholder = "Mobile Number",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 12.dp)
            )

            UniTextField(value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            )

            UniTextField(value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 12.dp)
            )

            UniTextField(value = repeatPassword,
                onValueChange = { repeatPassword = it },
                placeholder = "Repeat Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            )

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

            ButtonMeals(text = "Create Account",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 70.dp, vertical = 6.dp),
                onClick = {

                    when {

                        firstName.isEmpty() && lastName.isEmpty() && mobileNumber.isEmpty() && email.isEmpty() && password.isEmpty() && repeatPassword.isEmpty() -> {
                            showDialog = true
                            dialogMessage = "Please fill in all fields"
                        }

                        firstName.isEmpty() -> { showDialog = true; dialogMessage = "First Name is missing" }
                        lastName.isEmpty() -> { showDialog = true; dialogMessage = "Last Name is missing" }
                        mobileNumber.isEmpty() -> { showDialog = true; dialogMessage = "Mobile Number is missing" }
                        email.isEmpty() -> { showDialog = true; dialogMessage = "Email is missing" }
                        password.isEmpty() -> { showDialog = true; dialogMessage = "Password is missing" }
                        repeatPassword.isEmpty() -> { showDialog = true; dialogMessage = "Repeat is missing" }
                        password != repeatPassword -> { showDialog = true; dialogMessage = "Password does not match. Try Again" }

                        else -> {
                            navigateToScreen(Routes.Workout(showWelcomeSnackbar = true))
                        }

                    }

                })

        }

    }

}