package com.example.sqlite

import android.provider.BaseColumns


object CarContract {
    // Table contents are grouped together in an anonymous object.
    object CarEntry : BaseColumns {
        const val TABLE_NAME = "cars"
        const val COLUMN_NAME_MAKE = "make"
        const val COLUMN_NAME_MODEL = "model_name"
        const val COLUMN_NAME_YEAR_MODEL = "year_model"
        const val COLUMN_NAME_COLOR = "color"
        const val COLUMN_NAME_PRICE = "price"

        public const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${CarEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${CarEntry.COLUMN_NAME_MAKE} TEXT," +
                    "${CarEntry.COLUMN_NAME_MODEL} TEXT)"+
                    "${CarEntry.COLUMN_NAME_YEAR_MODEL} INTEGER," +
                    "${CarEntry.COLUMN_NAME_COLOR} TEXT)"+
                    "${CarEntry.COLUMN_NAME_PRICE} DOUBLE)"



         public const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${CarEntry.TABLE_NAME}"
    }
}