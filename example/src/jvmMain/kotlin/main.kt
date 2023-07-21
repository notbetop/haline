import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import top.notbe.haline.text.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import top.notbe.haline.button.ButtonColors
import top.notbe.haline.button.LargeButton
import top.notbe.haline.button.MediumButton
import top.notbe.haline.button.SmallButton
import top.notbe.haline.style.HalineTheme
import top.notbe.haline.switch.Switch

fun main() {
    singleWindowApplication {
        HalineTheme {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(10.dp)
            ) {
                Switches()
                Buttons()
            }
        }
    }
}

@Composable
fun Switches(){
    var enable by remember { mutableStateOf(false) }
    Switch(
        checked = enable,
        onChange = { enable = !enable }
    )
    Switch(
        checked = !enable,
        onChange = { enable = !enable }
    )
    Switch(
        checked = enable,
        disable = true,
        onChange = { enable = !enable }
    )
}
@Composable
fun Buttons(){
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        listOf(ButtonColors.primary, ButtonColors.secondary,ButtonColors.tertiary,ButtonColors.error).forEach {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                LargeButton(
                    colors = it,
                    onClick = {  }
                ) {
                    Text("Hello, world")
                }
                MediumButton(
                    colors = it,
                    onClick = {  }
                ) {
                    Text("Hello, world")
                }
                SmallButton(
                    colors = it,
                    onClick = {  }
                ) {
                    Text("Hello")
                }

                MediumButton(
                    colors = it,
                    disable = true,
                    onClick = {  }
                ) {
                    Text("Hello, world")
                }
            }
        }
    }

}