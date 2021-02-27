package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PuppyDetailScreen(
    puppyId: Int?
) {
    val puppy = Util.getPuppyWithIndex(puppyId)
    val typography = MaterialTheme.typography
    val description = Util.getPuppyDescriptionWithIndex(puppyId)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = puppy.id),
            contentDescription = puppy.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(300.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
        Text(
            text = puppy.name,
            style = typography.h4,
            modifier = Modifier.padding(start = 18.dp,top = 12.dp)
        )
        Row (
            verticalAlignment = Alignment.CenterVertically
                ){
            Image(
                painter = painterResource(
                    id = R.drawable.ic_location
                ),
                contentDescription = null,
                modifier = Modifier.padding(start = 12.dp, top = 2.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = puppy.location,
                style = typography.body1,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Text(
            text = "Breed: ${puppy.breed}",
            style = typography.h6,
            modifier = Modifier.padding(start = 16.dp, top = 12.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Gender: ${puppy.gender}",
                style = typography.h6,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )
            Image(
                painter = painterResource(
                    id = getGenderIcon(puppy.gender)
                ),
                contentDescription = null,
                modifier = Modifier.padding(start = 6.dp, top = 2.dp)
            )
        }

        Text(
            text = description,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp,top = 20.dp),
            fontWeight = FontWeight.W400,
            fontSize = 18.sp
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Button(
                onClick = {

                }
            ) {
                Text(text = "Adopt ${puppy.name}")
            }
        }

    }
}