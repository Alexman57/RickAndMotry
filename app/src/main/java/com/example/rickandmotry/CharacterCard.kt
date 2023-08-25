package com.example.rickandmotry

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmotry.retrofit.MyViewModel
import com.example.rickandmotry.ui.theme.DarkBlue




@Composable
fun CharacterCard(viewModel: MyViewModel) {
    val name = viewModel.name.observeAsState(initial = "Loading...")

    LaunchedEffect(Unit) {
        viewModel.fetchCharacterName()
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .background(DarkBlue),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                // сюда передавать картику
                painter = painterResource(id = R.drawable.image_1),
                contentDescription = "image",
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.gilroy_regular)),
                    fontWeight = FontWeight.Bold,
                    // сюда передать имя
                    text = name.value
                )
            }
        }
    }
}
