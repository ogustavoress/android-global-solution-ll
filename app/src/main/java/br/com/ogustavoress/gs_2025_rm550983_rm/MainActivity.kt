package br.com.ogustavoress.gs_2025_rm550983_rm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.ogustavoress.gs_2025_rm550983_rm.screens.EquipeScreen
import br.com.ogustavoress.gs_2025_rm550983_rm.screens.ImcScreen
import br.com.ogustavoress.gs_2025_rm550983_rm.screens.LoginScreen
import br.com.ogustavoress.gs_2025_rm550983_rm.screens.MenuScreen
import br.com.ogustavoress.gs_2025_rm550983_rm.ui.theme.GS_2025_RM550983_RM552481Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GS_2025_RM550983_RM552481Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }

                        composable("menu") {
                            MenuScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }

                        composable("calculadora") {
                            ImcScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }

                        composable("equipe") {
                            EquipeScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}
