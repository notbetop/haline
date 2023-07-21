package top.notbe.peter_record

import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication

fun main() {
    singleWindowApplication {
        WithContextMenu(
            items = {
                listOf(ContextMenuItem(label = "1") {})
            }
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.weight(1f).fillMaxWidth()) {

                    ContextMenuArea(
                        items = {
                            listOf(ContextMenuItem(label = "2") {})
                        }
                    ) {
                        Box(modifier = Modifier.height(100.dp).fillMaxWidth().background(Color.Red.copy(.2f))) {
                            ContextMenuArea(
                                items = {
                                    listOf(ContextMenuItem(label = "3") {})
                                }
                            ) {
                                Box(modifier = Modifier.height(30.dp).fillMaxWidth().background(Color.Red.copy(.2f))) {

                                }
                            }
                        }
                    }

                    Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Red))
                }
                Box(modifier = Modifier.background(Color.Yellow).weight(1f).fillMaxWidth())
            }
        }
    }
}

fun Modifier.gesturesDisabled(disabled: Boolean = true) =
    if (disabled) {
        pointerInput(Unit) {
            awaitPointerEventScope {
                while (true) {
                    awaitPointerEvent(pass = PointerEventPass.Initial)
                        .changes
                        .forEach(PointerInputChange::consume)
                }
            }
        }
    } else {
        this
    }