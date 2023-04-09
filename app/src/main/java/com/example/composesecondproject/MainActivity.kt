package com.example.composesecondproject

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composesecondproject.ui.theme.ComposeSecondProjectTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSecondProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TutorialImage(
                        header = stringResource(R.string.tutorial_header),
                        annotation = stringResource(R.string.tutorial_annotation),
                        description = stringResource(R.string.tutorial_description)
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialText(header: String, description: String, annotation: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = header,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
                .align(alignment = Alignment.Start)
        )
        Text(text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(text = annotation,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
        )
    }
}

@Composable
fun TutorialImage(header: String,
                  description: String,
                  annotation: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        TutorialText(header = header, description = description, annotation = annotation)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSecondProjectTheme {
        TutorialImage(
            header = stringResource(R.string.tutorial_header),
            annotation = stringResource(R.string.tutorial_annotation),
            description = stringResource(R.string.tutorial_description)
        )
    }
}