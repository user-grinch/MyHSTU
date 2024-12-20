package com.enan.myhstu.data

data class Faculty(val name: String, val departments: List<String>)

val faculties = listOf(
    Faculty(
        "Agriculture", listOf(
            "Agronomy",
            "Horticulture",
            "Soil Science",
            "Entomology",
            "Plant Pathology",
            "Genetics & Plant Breeding",
            "Crop Physiology & Ecology",
            "Agricultural Extension",
            "Agricultural Chemistry",
            "Agroforestry And Environment",
            "Biochemistry & Molecular Biology"
        )
    ),
    Faculty(
        "Computer Science and Engineering", listOf(
            "Computer Science and Engineering",
            "Electrical and Electronic Engineering",
            "Electronics and Communication Engineering"
        )
    ),
    Faculty(
        "Business Studies", listOf(
            "Accounting",
            "Finance and Banking",
            "Management",
            "Marketing"
        )
    ),
    Faculty(
        "Fisheries", listOf(
            "Fisheries Biology & Genetics",
            "Fisheries Management",
            "Fisheries Technology",
            "Aquaculture"
        )
    ),
    Faculty(
        "Veterinary and Animal Science", listOf(
            "Microbiology",
            "Pathology & Parasitology",
            "Dairy & Poultry Science",
            "Anatomy & Histology",
            "General Animal Science & Nutrition",
            "Genetics & Animal Breeding",
            "Medicine, Surgery and Obstetrics",
            "Physiology & Pharmacology"
        )
    ),
    Faculty(
        "Engineering", listOf(
            "Agricultural & Industrial Engineering",
            "Food Processing & Preservation",
            "Food Engineering & Technology",
            "Food Science & Nutrition",
            "Architecture",
            "Civil Engineering",
            "Mechanical Engineering"
        )
    ),
    Faculty(
        "Science", listOf(
            "Chemistry",
            "Physics",
            "Mathematics",
            "Statistics"
        )
    ),
    Faculty(
        "Social Science and Humanities", listOf(
            "English",
            "Economics",
            "Sociology",
            "Development Studies"
        )
    )
)