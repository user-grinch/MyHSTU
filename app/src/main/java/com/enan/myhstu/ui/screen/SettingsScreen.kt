package com.enan.myhstu.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.enan.myhstu.NavHandler
import com.enan.myhstu.data.UiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreenLayout(modifier: Modifier = Modifier, viewModel: UiViewModel) {
    // State for toggles
    var useMaterialColors by remember { mutableStateOf(true) }
    var useDefaultBrowser by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Material Colors Toggle
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Use Material Colors",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = useMaterialColors,
                onCheckedChange = { useMaterialColors = it }
            )
        }

        // Default Browser Toggle
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Use Default Browser",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = useDefaultBrowser,
                onCheckedChange = { useDefaultBrowser = it }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // About Us Section
        Text(
            text = "About Us",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = "This is a demo campus app developed for Hajee Mohammad Danesh Science & Technology University. " +
                    "It adheres to the latest Material You (MDY) and Material Design 3 (MD3) principles, " +
                    "providing a modern and dynamic user experience built with Jetpack Compose.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Visit HSTU Website
            Button(
                onClick = { },
                content = {
                    Text(
                        text = "HSTU Website",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )

            // Contact Us Section
            Button(
                onClick = { },
                content = {
                    Text(
                        text = "Source Code",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        }

        Spacer(modifier = Modifier.weight(0.1f))

        Text(
            text = "Version: 1.0.0",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Developed by Enan Ahammad",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHandler()
}

