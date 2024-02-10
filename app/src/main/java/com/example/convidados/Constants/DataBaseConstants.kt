package com.example.convidados.Constants

import com.google.android.material.internal.NavigationMenu

class DataBaseConstants private constructor(){

    object GUEST {
        const val TABLE_NAME = "Guest"

        object COLUMNS{
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }

    }

}