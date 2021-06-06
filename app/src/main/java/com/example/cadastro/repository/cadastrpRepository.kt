package com.example.cadastro.repository

import androidx.lifecycle.LiveData
import com.example.cadastro.data.db.entity.cadastroEntity

interface cadastrpRepository {


    suspend fun insertCadastro(name: String, email: String): Long

    suspend fun updateCadastro(id: Long, name: String, email: String)

    suspend fun deleteCadastro(id:Long)

    suspend fun deleteAllCadastro()

    suspend fun getAllCadastro(): LiveData<List<cadastroEntity>>

}