package com.example.cadastro.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cadastro.data.db.dao.cadastroDao
import com.example.cadastro.data.db.entity.cadastroEntity
import android.content.Context as Context

@Database(entities = [cadastroEntity::class], version=1)
 abstract class AppDataBase : RoomDatabase() {

     abstract val CadastroDao: cadastroDao

     companion object {

         @Volatile
         private var INSTANCE: AppDataBase? = null

         fun getInstace(context: Context): AppDataBase {
             synchronized(this) {
                 var instance: AppDataBase? = INSTANCE
                 if (instance == null) {
                     instance = Room.databaseBuilder(
                         context,
                         AppDataBase::class.java,
                         "app_database"

                     ).build()
                 }
                 return instance
             }
         }
     }
}