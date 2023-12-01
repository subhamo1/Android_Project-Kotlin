package com.example.jetbizcard

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    CreateBizcard()

                }
            }
        }
    }
}
@Composable
fun CreateBizcard() {
    val buttonClickedstate = remember {
        mutableStateOf(value = false  )

    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp)
            .background(Color.White),

            shape = RoundedCornerShape(corner = CornerSize(15.dp)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            )


        {
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally)
            {

                CreateImageProfile()
                Divider(modifier=Modifier
                    .padding(horizontal = 1.dp, vertical = 1.dp),
                    color = Color.Black,
                    thickness = 5.dp,
                )
                Createinfo()
                Button(onClick = {
                    buttonClickedstate.value= !buttonClickedstate.value


                }



                )

                {
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.bodyMedium

                        )

                }

                if (buttonClickedstate.value) {
                    content()

                }else{
                    Box{}
                }



            }
        }
        
    }
    
}

@Composable

private fun Createinfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Subham Patra.",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(4.dp)
        )

        Text(
            text = "BusinessCard",
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.bodySmall

        )

    }
}




@Composable
fun  content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(
                3.dp
            )
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp,color= Color.Yellow))

        {
            Portfolio(data= listOf("project1","Project2","Project3","Project4"))


        }
    }
}
@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(){
        items(data){item ->
            Card (modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape= RectangleShape,
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),){
                Row(modifier = Modifier
                    .padding(7.dp)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)) {
                    CreateImageProfile(modifier = Modifier.size(45.dp))
                    Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {


                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A Great Project",
                            style = MaterialTheme.typography.bodyMedium

                            )
                    }

                }
            }

            }


        }
    }


@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,

        border = BorderStroke(0.5.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "profile",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop

        )


    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        CreateBizcard()

    }
}