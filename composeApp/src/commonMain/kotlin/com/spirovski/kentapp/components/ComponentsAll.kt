package com.spirovski.kentapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UniTextField(value: String, onValueChange: (String) -> Unit, placeholder: String, modifier: Modifier = Modifier) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        minLines = 1,
        maxLines = 50,
        placeholder = { Text(placeholder) },
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedLabelColor = Color.LightGray, focusedLabelColor = Color.Gray,
            unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent))

}

@Composable
fun ButtonMeals(text: String, modifier: Modifier = Modifier) {

    Button(onClick = {},
        modifier = modifier,
        shape = RoundedCornerShape(7.dp)) {
        Text(text = text)

    }

}