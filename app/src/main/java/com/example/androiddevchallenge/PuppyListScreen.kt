package com.example.androiddevchallenge

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.theme.AndroidDevChallengeTheme

@ExperimentalFoundationApi
@Composable
fun PuppyListScreen(
    navFunction: (String) -> Unit,
    list: ArrayList<Puppy>?,
    viewModel: MainViewModel
) {
    //val viewModel: MainViewModel = viewModel("MainVM")

    AndroidDevChallengeTheme(
        darkTheme = viewModel.darkmode.value
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        ) {
            val typography = MaterialTheme.typography

            Row(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 10.dp, end = 8.dp, top = 8.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit
                )
                Column(
                    modifier = Modifier.padding(top = 18.dp,start = 6.dp)
                ) {
                    Text(
                        text = "Welcome to",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 28.sp,
                        color = Color(0xFFD2691E)
                    )
                    Text(
                        text = "Puppy Adoption!",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 28.sp,
                        color = Color(0xFFD2691E)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = if(viewModel.darkmode.value) R.drawable.dark else R.drawable.light),
                    contentDescription = "toggle",
                    modifier = Modifier.clickable(
                        onClick = { viewModel.toggle() }
                    )
                        .padding(8.dp)
                )
            }

            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 20.dp)
            ) {
                items(list ?: mutableListOf()) { user ->
                    UserListItem(
                        puppy = user,
                        viewModel = viewModel,
                        onClick = navFunction,
                    )
                }
            }

        }
    }
}

@Composable
fun UserListItem(puppy: Puppy, viewModel: MainViewModel,onClick: (String) -> Unit) {
    val typography = MaterialTheme.typography

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                top = 6.dp
            )
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = {
                val route = Screen.PuppyDetailScreen.route + "/${puppy.index}"
                onClick(route)
            }),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = puppy.id),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, bottom = 8.dp, end = 8.dp)
                    .height(100.dp)
                    .width(100.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )

            Column(

            ) {
                Text(
                    text = puppy.name,
                    style = typography.h5,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(top = 6.dp,start = 16.dp),
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = puppy.breed,
                    style = typography.body1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 16.dp),
                    color = MaterialTheme.colors.onSurface
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_location
                        ),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(1.dp))
                    Text(
                        text = puppy.location,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W300,
                        color = MaterialTheme.colors.onSurface
                    )
                }

            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = puppy.gender,
                    style = typography.body1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colors.onSurface
                )
                Image(
                    painter = painterResource(
                        id = getGenderIcon(puppy.gender)
                    ),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 4.dp,end = 12.dp),
                )
            }

        }
    }
}

fun getGenderIcon(breed: String): Int {
    if(breed.equals("Male")) return R.drawable.gender_male
    else return R.drawable.gender_female
}