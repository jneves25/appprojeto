package com.example.cadastro.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cadastro.data.db.entity.cadastroEntity

@Dao
interface cadastroDao {

    @Insert
    suspend fun insert(cadastros: cadastroEntity): Long

    @Update
    suspend fun update(cadastros: cadastroEntity)

    @Query("DELETE FROM cadastros WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM cadastros")
    suspend fun deleteAll()

    @Query("SELECT * FROM cadastros")
    fun getAll(): LiveData<List<cadastroEntity>>

}