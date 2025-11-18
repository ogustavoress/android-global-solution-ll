package br.com.ogustavoress.gs_2025_rm550983_rm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Arrangement

@Composable
fun ImcScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    fun calcularIMC() {
        if (nome.isBlank() || peso.isBlank() || altura.isBlank()) {
            resultado = "Preencha todos os campos!"
            return
        }

        val p = peso.replace(",", ".").toFloatOrNull()
        val a = altura.replace(",", ".").toFloatOrNull()

        if (p == null || a == null || a <= 0f) {
            resultado = "Informe valores numéricos válidos."
            return
        }

        val imc = p / (a * a)

        val status = when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 24.9 -> "Peso normal"
            imc < 29.9 -> "Sobrepeso"
            imc < 34.9 -> "Obesidade I"
            imc < 39.9 -> "Obesidade II"
            else -> "Obesidade III"
        }

        resultado = "Olá, $nome!\nIMC: %.2f\nStatus: %s".format(imc, status)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = "Cálculo de IMC",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Seu nome") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFED145B),
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.White,
                    focusedLabelColor = Color(0xFFED145B),
                    unfocusedLabelColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = peso,
                onValueChange = { peso = it },
                label = { Text("Seu peso (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFED145B),
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.White,
                    focusedLabelColor = Color(0xFFED145B),
                    unfocusedLabelColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Sua altura (m)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFED145B),
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.White,
                    focusedLabelColor = Color(0xFFED145B),
                    unfocusedLabelColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { calcularIMC() },
                colors = ButtonDefaults.buttonColors(Color(0xFFED145B)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Calcular", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (resultado.isNotEmpty()) {
                Text(
                    text = resultado,
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

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
