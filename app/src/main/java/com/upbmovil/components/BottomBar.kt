package com.upbmovil.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.upbmovil.ui.theme.UPBMovilTheme

private data class BottomDestination(
    val label: String,
    val icon: @Composable () -> Unit
)

@Composable
fun UPBBottomBar() {
    val items = listOf(
        BottomDestination("Servicios") { Icon(Icons.Default.Storefront, contentDescription = null) },
        BottomDestination("Pedido") { Icon(Icons.Default.ReceiptLong, contentDescription = null) },
        BottomDestination("Historial") { Icon(Icons.Default.History, contentDescription = null) }
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == 0,
                onClick = { },
                icon = item.icon,
                label = { Text(item.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF6D28D9),
                    selectedTextColor = Color(0xFF6D28D9)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UPBBottomBarPreview() {
    UPBMovilTheme {
        UPBBottomBar()
    }
}
