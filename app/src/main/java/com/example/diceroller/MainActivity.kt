package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                    DiceRollerApp()
                }
            }
        }
    }

/*
DiceWithButtonImage() function will represent UI components and
will hold the button and image display logic
 */
@Composable
/*
modifier parameter preset to a Modifier object type.  Allows user to
to call method and decide to pass a value for the parameter.  User can
customize the behavior and decoration of UI.
 */
fun DiceWithButtonImage(modifier: Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    //Children within column are centered w/ respect to device width
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
            ){
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()  //Content description for accessibility
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random()}){
            Text(stringResource(R.string.Roll))
        }
    }
}




/*
The DiceRollerApp() function will act as the app itself.
 */
@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){
    DiceWithButtonImage(modifier = Modifier
        .fillMaxSize() //Fills the entire screen
        .wrapContentSize(Center) //How components align within available space
    //Centered vertically and horizontally
    )
}