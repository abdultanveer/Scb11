package com.example.scb11.data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

//like a kitchen -- fetch the data from local/remote source

class ItemRepository(private val itemDao: ItemDao) {

    val allItems: Flow<List<Item>> = itemDao.getItems()


    suspend fun getUserById(id: Int): Flow<Item?> {
        return itemDao.getItem(id)//3
    }
}