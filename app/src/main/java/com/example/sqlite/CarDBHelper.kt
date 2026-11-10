package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CarDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CarContract.CarEntry.SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(CarContract.CarEntry.SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    fun insertCar(car: Car) {
     val database = writableDatabase

        val values = ContentValues().apply {
            put(CarContract.CarEntry.COLUMN_NAME_MAKE, car.make )
            put(CarContract.CarEntry.COLUMN_NAME_MODEL, car.model)
            put(CarContract.CarEntry.COLUMN_NAME_YEAR_MODEL, car.year)
            put(CarContract.CarEntry.COLUMN_NAME_COLOR, car.color)
            put(CarContract.CarEntry.COLUMN_NAME_PRICE, car.price)
        }

        database.insert(CarContract.CarEntry.TABLE_NAME,null,values)

        database.close()
    }

    fun deleteCar() {
        val database = writableDatabase


        database.close()

    }

    fun getAllCars() {
        val cars: ArrayList<Car> = arrayListOf()


  val database = readableDatabase
        val cursor = database.query(CarContract.CarEntry.TABLE_NAME, null, null, null, null, null, null, null)
        while (cursor.moveToNext())
        {
            val car = Car(cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getString(4),
                cursor.getFloat(5))

        }
        database.close()
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "cars.db"
    }
}