package com.belajar.scrollchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belajar.scrollchallenge.data.DataSource
import com.belajar.scrollchallenge.model.TopicModel
import com.belajar.scrollchallenge.ui.theme.ScrollChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicPreview()
                }
            }
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun TopicPreview() {
CardTopic()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardTopic() {
        LazyVerticalGrid(cells = GridCells.Fixed(2),
                         verticalArrangement = Arrangement.spacedBy(8.dp),
                         horizontalArrangement = Arrangement.spacedBy(8.dp),
                         modifier = Modifier.padding(8.dp)) {
            items(DataSource().listItem()) {
                CardTemplate(model = it)
            }

        }



    }
@Composable
fun CardTemplate(model:TopicModel) {
    Card(elevation = 4.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(5.dp)) {
        Row {

            Card(elevation = 4.dp, modifier = Modifier.wrapContentWidth()) {
                Image(painter = painterResource(id = model.gambar),
                    contentDescription = stringResource(id = model.tulisan),
                    modifier = Modifier
                        .height(68.dp)
                        .width(68.dp))
            }

            Column( modifier = Modifier.absolutePadding(16.dp,16.dp,16.dp,8.dp)) {

                Text(text = stringResource(id = model.tulisan))
                Text(text = model.id.toString())

            }

        }
    }

}
