package br.senai.sp.jandira.bmicompose.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun colorBMI(colorSate: Int):Color {
    return (when (colorSate) {
        0 -> Color.Red
        1 -> MaterialTheme.colors.primary
        2 -> Color.Yellow
        3 -> Color.Red
        else -> { MaterialTheme.colors.primary}
    })
}