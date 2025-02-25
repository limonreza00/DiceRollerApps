package org.coderscastle.kmp_dice_roller

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import dicerollerapps.composeapp.generated.resources.Res
import dicerollerapps.composeapp.generated.resources.compose_multiplatform
import dicerollerapps.composeapp.generated.resources.*

@Composable
@Preview
fun App() {
    MaterialTheme {

        DiceRollerMain()
    }
}

@Composable
fun DiceRollerMain(){

    val  isPlayer1 = remember { mutableStateOf(true) }

    val playerScores = remember { mutableStateOf(Array(2) { 0 }) }

    val diceImages = remember {
        mutableListOf(
            Res.drawable.dice_1,
            Res.drawable.dice_2,
            Res.drawable.dice_3,
            Res.drawable.dice_4,
            Res.drawable.dice_5,
            Res.drawable.dice_6
        )
    }
    var currentDiceImage by remember { mutableStateOf(Res.drawable.compose_multiplatform) }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to Dice Roller !",
            modifier = Modifier
        )
        Spacer(modifier = Modifier.padding(16.dp))

        Image(
            painter = painterResource(currentDiceImage),
            contentDescription = "Dice")

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = {
                val randomNum = (1..6).random()
                currentDiceImage = diceImages[randomNum - 1]
                if (isPlayer1.value) {
                    playerScores.value[0] += randomNum
                } else {
                    playerScores.value[1] += randomNum
                }
                isPlayer1.value = !isPlayer1.value

            }
        ) {
            if (isPlayer1.value) Text("Player 1") else Text("Player 2")
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(text = "Player 1 \n ${playerScores.value[0]} ")

            Text(text = "Player 1 \n ${playerScores.value[1]} ")
        }

    }
}
