package com.enan.myhstu.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enan.myhstu.NavHandler
import com.enan.myhstu.R
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.data.homePageItems
import com.enan.myhstu.ui.CardLayout
import com.google.android.gms.maps.model.Circle

@Composable
fun SectionHeader(title: String) {
    Spacer(modifier = Modifier.padding(20.dp))
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun BulletList(items: List<String>) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun DataTable(rows: List<Pair<String, String>>) {
    Column {
        rows.forEach { (key, value) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(key, style = MaterialTheme.typography.bodyMedium)
                Text(value, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun OverviewScreenLayout(viewModel: UiViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        var isExpanded by remember { mutableStateOf(false) }

        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 12.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                if (isExpanded) {
                    Image(
                        painter = painterResource(id = R.drawable.danesh_pic), // Replace with your image resource
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp) // Adjust the height as needed
                            .clip(RoundedCornerShape(8.dp)) // Rounded corners
                            .padding(top = 8.dp) // Optional padding
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (isExpanded) {
                        "Hajee Mohammad Danesh (1900-1986) was a peasant leader and politician. He was born in Sultanpur village in Dinajpur District. He obtained his M.A. in History from Aligarh Muslim University in 1931 and B.L. degree in 1932. In the 1930s, Danesh became active in the communist organisations of Bengal, especially the Bengal provincial organisation of the Communist Party of India. He was arrested twice in 1938 by the government of Bengal for his participation in the Tebhaga movement, an agitation in northern Bengal against zamindars landlords for landless peasants and sharecroppers who sought a greater share of the yield, most of which was surrendered to the zamindars. Danesh was one of the few Muslim communist leaders of the struggle, and worked to mobilise the Muslim peasantry in favour of the movement. In 1945, he joined the All India Muslim League, but was later expelled for his participation in the continuing Tebagha movement, and rearrested by the Bengal government in 1946. After the partition of India and Bengal in 1947, Danesh remained in his home district of Dinajpur, which fell in Muslim-majority East Bengal, which became part of the newly created Muslim state of Pakistan. He died in Dhaka on 28 June 1986."
                    } else {
                        "Hajee Mohammad Danesh (1900-1986) was a peasant leader and politician. He was born in Sultanpur village in Dinajpur District. He obtained his M.A. in History..."
                    },
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.padding(0.dp)
                ) {
                    Text(text = if (isExpanded) "Read Less" else "Read More")
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 12.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "The Act of the University was passed on 8 July 2001 in the Jatio Shongsad (National Assembly) and followed by a gazette notification on 8 April 2002.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        SectionHeader(title = "Key Information")
        DataTable(
            rows = listOf(
                "First VC Appointment" to "8 April 2002",
                "Land Area" to "85 Acres",
                "Location" to "About 10 km North of Dinajpur",
                "Faculties" to "9",
                "Degrees Offered" to "24",
                "Departments" to "45",
                "Residential Halls" to "5 (Male)  4 (Female)",
            )
        )

        // Faculties Section
        SectionHeader(title = "Faculties")
        BulletList(items = listOf(
            "Agriculture", "Computer Science & Engineering", "Business Studies", "Engineering",
            "Fisheries", "Veterinary & Animal Science", "Science", "Social Science & Humanities",
            "Post Graduate Studies"
        ))

        // Degree Programs Section
        SectionHeader(title = "Degree Programs")
        BulletList(items = listOf(
            "BSc in Agriculture (Hons.)", "BSc in Computer Science and Engineering",
            "BSc in Electronic and Communication Engineering", "BSc in Electrical and Electronics Engineering",
            "BBA in Accounting and Information System",
            "BBA in Management", "BBA in Marketing", "BBA in Finance",
            "BSc in Fisheries (Hons.)", "BSc in Food and Process Engineering",
            "BSc in Agricultural Engineering", "Bachelor of Architecture",
            "BSc in Civil Engineering", "BSc in Mechanical Engineering",
            "Doctor of Veterinary Medicine", "BSc (Hons.) in Chemistry",
            "BSc (Hons.) in Physics", "BSc (Hons.) in Mathematics",
            "BSc (Hons.) in Statistics", "BA (Hons.) in English",
            "BSS (Hons) in Economics", "BSS (Hons) in Sociology",
            "BSS (Hons) in Development Studies", "MS/MBA and PhD"
        ))

        // Degree Programs Section
        SectionHeader(title = "Residential Halls")
        BulletList(items = listOf(
            "Sheikh Russel Hall", "Shaheed President Ziaur Rahman Hall",
            "Tajuddin Ahmad Hall", "Bangabandhu Sheikh Mujibur Rahman Hall",
            "Sheikh Fazilatunnesa Mujib Hall", "Ivy Rahman Hall",
            "Kobi Sufia Kamal Hall", "Sheikh Sayera Khatun Hall",
            "International Hall"
        ))

        SectionHeader(title = "Statistics")
        DataTable(
            rows = listOf(
                "Teachers" to "388",
                "Students" to "About 11000",
                "Officers" to "211",
                "Staff" to "302",
                "Library" to "About 21,000 books, 50 periodicals",
                "School" to "1 (HSTU School)",
                "Affiliated Institute" to "\n\nShahid Akbar Ali Science & Technology College, Baliadangi, Thakurgaon",
            )
        )

        SectionHeader(title = "Contact")
        DataTable(
            rows = listOf(
                "Phone" to "+880-531-61355",
                "Fax" to "+880-531-61311",
                "Email" to "vice-chancellor@hstu.ac.bd",
                "Website" to "www.hstu.ac.bd"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHandler()
}
