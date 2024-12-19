package com.enan.myhstu.data

import androidx.annotation.DrawableRes
import com.enan.myhstu.R

data class VCItem (
    @DrawableRes val picture: Int,
    val name: String = "",
    val role: String = "",
    val timeline: String = "",
)

val presidentItem = VCItem(
    picture = R.drawable.president,
    name = "Mohammed Shahabuddin",
    role = "Hon'ble President",
    timeline = "People's Republic of Bangladesh",
)

val vcItems = listOf(
    VCItem(
        picture = R.drawable.vc_mosharof,
        name = "Dr. Mosharrof Hossain Miah",
        role = "Professor",
        timeline = "8 April 2002 - 30 August 2006"
    ),
    VCItem(
        picture = R.drawable.male,
        name = "Dr. Md. Motaher Hossain Mondol",
        role = "Professor",
        timeline = "31 August 2006 - 21 April 2007"
    ),
    VCItem(
        picture = R.drawable.vc_ruhulamin,
        name = "Md. Ruhul Amin",
        role = "Professor",
        timeline = "22 April 2007 - 02 September 2008"
    ),
    VCItem(
        picture = R.drawable.vc_afzal,
        name = "Dr. Md. Afzal Hossain",
        role = "Professor",
        timeline = "03 September 2008 - 12 September 2012"
    ),
    VCItem(
        picture = R.drawable.vc_ruhulamin,
        name = "Md. Ruhul Amin",
        role = "Professor",
        timeline = "27 September 2012 - 26 September 2016"
    ),
    VCItem(
        picture = R.drawable.vc_kashem,
        name = "Dr. M. Abul Kashem",
        role = "Professor",
        timeline = "02 February 2017 - 01 February 2021"
    ),
    VCItem(
        picture = R.drawable.vc_bidhan,
        name = "Dr. Bidhan Chandra Halder",
        role = "Professor (Routine Duty)",
        timeline = "22 February 2021 - 29 June 2021"
    ),
    VCItem(
        picture = R.drawable.vc_kamruzzaman,
        name = "Dr. M. Kamruzzaman",
        role = "Professor",
        timeline = "30 June 2021 - 11 August 2024"
    ),
    VCItem(
        picture = R.drawable.vc_enamullah,
        name = "Dr. M. Enamullah",
        role = "Vice Chancellor",
        timeline = "23 October 2024 - Present"
    )
)