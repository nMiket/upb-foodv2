package com.upbmovil.models

enum class CafeteriaStatus {
    OPEN,
    HIGH_DEMAND
}

data class Cafeteria(
    val name: String,
    val location: String,
    val status: CafeteriaStatus,
    val estimatedTimeMinutes: Int
)
