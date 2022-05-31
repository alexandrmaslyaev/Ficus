package com.example.ficus.ui.plants.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ficus.R
import com.example.ficus.ex.str
import com.example.ficus.ui.common.TextButton
import com.example.ficus.ui.compose.theme.FicusTheme

@Composable
fun MyPlantCard(vs: MyPlantVs) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .size(width = 144.dp, height = 88.dp),
        backgroundColor = colorResource(id = R.color.brander_green)
    ) {
        Row {
            Column(Modifier
                .size(width = 80.dp, height = 88.dp)
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)) {
                val context = LocalContext.current
                Text(text = vs.name.getString(context),
                    style = FicusTheme.typography.h3,
                    color = colorResource(id = R.color.white)
                )
                Text(
                    text = context.str(R.string.main_screen_my_plant_card_description),
                    style = FicusTheme.typography.body2,
                    color = colorResource(id = R.color.white)
                )
                Text(text = vs.time.getString(context),
                    style = FicusTheme.typography.body2,
                    color = colorResource(id = R.color.white)
                )
                Spacer(modifier = Modifier.size(width = 0.dp, height = 8.dp))
                TextButton(vs = vs.button){

                }
            }
            Image(
                modifier = Modifier.offset(y = 8.dp),
                painter = painterResource(id = vs.image.id),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart,
            )
        }
    }
}