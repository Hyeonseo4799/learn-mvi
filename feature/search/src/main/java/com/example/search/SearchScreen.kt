package com.example.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel(),
    showSnackBar: (String) -> Unit,
    navigateToUser: (String) -> Unit,
) {
    val uiState by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is SearchSideEffect.ShowError -> showSnackBar(uiState.error)
            is SearchSideEffect.NavigateToUser -> navigateToUser(sideEffect.query)
        }
    }

    SearchScreen(
        enterQuery = viewModel::enterQuery,
    )
}

@Composable
internal fun SearchScreen(
    enterQuery: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var query by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BasicTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(vertical = 16.dp),
            textStyle = TextStyle(fontSize = 18.sp),
            decorationBox = @Composable { innerTextField ->
                Box(modifier = Modifier.padding(start = 12.dp)) {
                    innerTextField()
                    if (query == "") {
                        Text(
                            text = "유저 명을 입력해주세요.",
                            color = Color.Gray
                        )
                    }
                }
            }
        )

        Button(
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 24.dp),
            onClick = { enterQuery(query) },
        ) {
            Text(text = "유저 검색")
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    SearchScreen(
        enterQuery = { },
    )
}
