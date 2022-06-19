package com.evgeny_minaenkov.chibbis.presenter.app_views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchView(state: MutableState<TextFieldValue>, OnClick: (TextFieldValue) -> Unit) {
    TopAppBar(backgroundColor = Color.White) {
        TextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
                OnClick.invoke(value)
            },
            label = { Text(text = "Поиск ресторана") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(Color.Black, fontSize = 18.sp),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "search",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            },
            trailingIcon = {
                if (state.value != TextFieldValue("")) {
                    IconButton(
                        onClick = {
                            state.value = TextFieldValue("")
                            OnClick.invoke(TextFieldValue(""))
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "clear_search",
                            modifier = Modifier
                                .padding(15.dp)
                                .size(24.dp)
                        )
                    }
                }
            },
            singleLine = true,
            shape = RectangleShape,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                cursorColor = Color.LightGray,
                trailingIconColor = Color.Black,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.Black,
                leadingIconColor = Color.Black
            ),
        )
    }
}

