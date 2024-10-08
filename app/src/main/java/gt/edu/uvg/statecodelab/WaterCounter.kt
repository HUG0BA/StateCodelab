package gt.edu.uvg.statecodelab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }
        if (count > 0) {
            Text(
                text = "You've had $count glasses"
            )
        }
        Button(
            onClick = {count++},
            Modifier.padding(top =8.dp), enabled = count <11){
            Text("Add one")
        }
    }
}

@Composable
fun StatelessCounter(modifier: Modifier = Modifier, count: Int, onIncrement: () -> Unit) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(
                text = "You've had $count glasses"
            )
        }

        Button(
            onClick = {onIncrement()},
            Modifier.padding(top = 8.dp), enabled = count < 11){
            Text("Add one")
        }

    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    StatelessCounter(count = count, onIncrement = {count++})
}