package br.com.ogustavoress.gs_2025_rm550983_rm.screens

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EquipeScreen(modifier: Modifier = Modifier,
              navController: NavController
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
            .padding(32.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "EQUIPE",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Integrantes",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            BulletItem("Gustavo Carvalho — RM 550983")
            Spacer(modifier = Modifier.height(8.dp))

            BulletItem("Letícia Vitalino — RM 552481")

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { navController.navigate("menu") },
                colors = ButtonDefaults.buttonColors(Color(0xFFED145B)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Voltar", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun BulletItem(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "•",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}