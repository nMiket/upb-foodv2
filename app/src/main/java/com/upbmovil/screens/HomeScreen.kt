package com.upbmovil.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upbmovil.components.CafeteriaCard
import com.upbmovil.components.UPBBottomBar
import com.upbmovil.models.Cafeteria
import com.upbmovil.models.CafeteriaStatus
import com.upbmovil.ui.theme.UPBMovilTheme

private val cafeterias = listOf(
    Cafeteria("Café Central", "Bloque 11", CafeteriaStatus.HIGH_DEMAND, 15),
    Cafeteria("Restaurante Bienestar", "Bloque 9", CafeteriaStatus.OPEN, 5),
    Cafeteria("Snack Bar", "Bloque 7", CafeteriaStatus.OPEN, 2)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var query by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = { UPBBottomBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Text(
                    text = "UPB Móvil",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            item {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Buscar productos, menús...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    singleLine = true
                )
            }

            item {
                Text(
                    text = "Cafeterías",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
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
