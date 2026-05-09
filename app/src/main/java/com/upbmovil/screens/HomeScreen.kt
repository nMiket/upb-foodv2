package com.upbmovil.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upbmovil.components.CafeteriaCard
import com.upbmovil.components.UPBBottomBar
import com.upbmovil.models.Cafeteria
import com.upbmovil.models.CafeteriaStatus
import com.upbmovil.ui.theme.UPBMovilTheme

private const val CafeCentralImageUrl =
    "https://lh3.googleusercontent.com/aida-public/AB6AXuBCKIee2MrK4SgLDxzmzcQMcnIkWb1Gw9qpPBq-sL-VODZ27Z2u1ZNkBqjLW66lwDGK_0hq73uP4m0VBJ8IH2mxGXgOhX1O3nWQBKBBrKztgXCDQCgQz8kEIOAswlAEXcn3SXHMgon3_6rKlAjKhiXZEvVRlkpXK0fN5kHEWRSekbnDjPT0SQ3tccnVlvxrf8uAgDDVmnA9Lc52ana6xF8F7d9L-O_bqUtGpksJYincDAnZ1n7fbsZFXYSTwfjXjNWZEM94fX7Eix8"
private const val RestauranteBienestarImageUrl =
    "https://lh3.googleusercontent.com/aida-public/AB6AXuC5fVoUpF8P2zRjJxxsFrfm_xZ59t45Gp2peDqvb7XycizGnO4srWYu8rWfqxQGutp4-jdap_fugi6mWs1uC301NRT3Si_CP9fjW90QKsOdkXVxCAiXEGlk3oX-0H6T32zq_B642jnm2DoMTpUsDVhLsCVUSpGjdLMivyk9gXFCdc6gvV5X886VDHWCBfp5j9eSWddx5ba9f9LQZqzYy_0aTnzvBYhJCnXyefBi1aP7SvlZuzgZ1amyKH_OzYgHMz6N4j8UryvkwZU"

private val cafeterias = listOf(
    Cafeteria(
        "Café Central",
        "Bloque 11",
        CafeteriaStatus.HIGH_DEMAND,
        15,
        CafeCentralImageUrl
    ),
    Cafeteria(
        "Restaurante Bienestar",
        "Bloque 9",
        CafeteriaStatus.OPEN,
        5,
        RestauranteBienestarImageUrl
    ),
    Cafeteria("Snack Bar", "Bloque 7", CafeteriaStatus.OPEN, 2, null)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var query by remember { mutableStateOf("") }
    val backgroundColor = Color(0xFFF9F9F9)
    val outlineColor = Color(0xFFC5C5D6)
    val placeholderColor = Color(0xFF757685)
    val searchShape = RoundedCornerShape(50)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "UPB Móvil",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .shadow(6.dp)
                    .statusBarsPadding()
            )
        },
        bottomBar = { UPBBottomBar() },
        containerColor = backgroundColor
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(6.dp, shape = searchShape, clip = false),
                    placeholder = { Text("Buscar productos, menús...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    singleLine = true,
                    shape = searchShape,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = outlineColor,
                        unfocusedBorderColor = outlineColor,
                        focusedLeadingIconColor = placeholderColor,
                        unfocusedLeadingIconColor = placeholderColor,
                        focusedPlaceholderColor = placeholderColor,
                        unfocusedPlaceholderColor = placeholderColor
                    )
                )
            }

            item {
                Text(
                    text = "Cafeterías",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            items(cafeterias) { cafeteria ->
                CafeteriaCard(cafeteria = cafeteria)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    UPBMovilTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenDarkPreview() {
    UPBMovilTheme(darkTheme = true) {
        HomeScreen()
    }
}
