package com.example.cadastro.repository

import androidx.lifecycle.LiveData
import com.example.cadastro.data.db.dao.cadastroDao
import com.example.cadastro.data.db.entity.cadastroEntity

class DataBaseDataSource(
    private val CadastroDao: cadastroDao
) : cadastrpRepository {
    override suspend fun insertCadastro(name: String, email: String): Long {
        val cadastro = cadastroEntity(
            name = name,
            email = email
        )

        return CadastroDao.insert(cadastro)
    }

    override suspend fun updateCadastro(id: Long, name: String, email: String) {
         val cadastro = cadastroEntity(
             id = id,
             name = name,
             email = email

         )

        CadastroDao.update(cadastro)


    }

    override suspend fun deleteCadastro(id: Long) {
        CadastroDao.delete(id)
    }

    override suspend fun deleteAllCadastro() {
            CadastroDao.deleteAll()
    }

    override suspend fun getAllCadastro(): LiveData<List<cadastroEntity>> {
        return CadastroDao.getAll()
    }
}