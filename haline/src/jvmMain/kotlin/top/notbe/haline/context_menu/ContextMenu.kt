package top.notbe.haline.context_menu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.onClick
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.unit.dp

@Composable
fun WithContextMenuScope.ContextMenu(
    modifier: Modifier = Modifier,
    content: @Composable ContextMenuScope.() -> Unit
) {
    Box(modifier = Modifier.size(50.dp).background(Color.Blue))
}

@Composable
fun ContextMenuItem(
    modifier: Modifier = Modifier,
    content: @Composable ContextMenuScope.() -> Unit
) {

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WithContextMenu(
    modifier: Modifier = Modifier,
    contextMenu: @Composable WithContextMenuScope.() -> Unit,
    content: @Composable () -> Unit
) {
    var isContextMenuVisible by remember { mutableStateOf(false) }
    Box(modifier = Modifier.onClick(
        enabled = true,
        matcher = PointerMatcher.mouse(PointerButton.Secondary), // add onClick for every required PointerButton
        keyboardModifiers = { true }, // e.g { isCtrlPressed }; Remove it to ignore keyboardModifiers
        onClick = {
            isContextMenuVisible = true
        }
    )) {
        content()
    }
}

interface WithContextMenuScope
interface ContextMenuScope