package com.enan.myhstu.data

import androidx.annotation.DrawableRes
import com.enan.myhstu.R

data class ProfileData(
    val name: String,
    val department: String,
    val phone: String,
    val email: String,
    val rank: String,
    val roles: Set<String>,
    @DrawableRes val picture: Int = R.drawable.chancellor,
)

val personnelList = listOf(
    ProfileData(
        name = "John Doe",
        department = "CSE",
        phone = "123456789",
        email = "john.doe@gmail.com",
        rank = "Professor",
        roles = setOf("Advisor", "Examiner"),
        picture = R.drawable.male
    ),
    ProfileData(
        name = "Jane Smith",
        department = "EEE",
        phone = "987654321",
        email = "jane.smith@gmail.com",
        rank = "Assistant Professor",
        roles = setOf("Club Moderator", "Examiner"),
        picture = R.drawable.female
    ),
    ProfileData(
        name = "Michael Johnson",
        department = "ME",
        phone = "111223344",
        email = "michael.johnson@gmail.com",
        rank = "Lecturer",
        roles = setOf("Advisor", "Lab Supervisor"),
        picture = R.drawable.male
    ),
    ProfileData(
        name = "Emily Davis",
        department = "CSE",
        phone = "555666777",
        email = "emily.davis@gmail.com",
        rank = "Senior Lecturer",
        roles = setOf("Course Coordinator", "Examiner"),
        picture = R.drawable.female
    ),
    ProfileData(
        name = "David Wilson",
        department = "CE",
        phone = "888999000",
        email = "david.wilson@gmail.com",
        rank = "Professor",
        roles = setOf("Thesis Supervisor", "Club Moderator"),
        picture = R.drawable.male
    ),
    ProfileData(
        name = "Sarah Miller",
        department = "EEE",
        phone = "1122334455",
        email = "sarah.miller@gmail.com",
        rank = "Assistant Professor",
        roles = setOf("Advisor", "Lab Supervisor"),
        picture = R.drawable.female
    ),
    ProfileData(
        name = "James Brown",
        department = "ME",
        phone = "9988776655",
        email = "james.brown@gmail.com",
        rank = "Lecturer",
        roles = setOf("Club Moderator", "Examiner"),
        picture = R.drawable.male
    ),
    ProfileData(
        name = "Linda Martinez",
        department = "CE",
        phone = "6677889900",
        email = "linda.martinez@gmail.com",
        rank = "Senior Lecturer",
        roles = setOf("Thesis Supervisor", "Course Coordinator"),
        picture = R.drawable.female
    ),
    ProfileData(
        name = "Robert Anderson",
        department = "CSE",
        phone = "1234432112",
        email = "robert.anderson@gmail.com",
        rank = "Assistant Professor",
        roles = setOf("Advisor", "Examiner"),
        picture = R.drawable.male
    ),
    ProfileData(
        name = "Patricia Thomas",
        department = "EEE",
        phone = "3344556677",
        email = "patricia.thomas@gmail.com",
        rank = "Professor",
        roles = setOf("Course Coordinator", "Club Moderator"),
        picture = R.drawable.female
    )
)
