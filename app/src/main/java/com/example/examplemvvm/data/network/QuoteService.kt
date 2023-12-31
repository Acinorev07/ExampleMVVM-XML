package com.example.examplemvvm.data.network


import com.example.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api:QuoteApiClient
) {

    suspend fun getQuotes():List<QuoteModel> {

        return withContext (Dispatchers.IO) {
            val response = api.getAllQuotes()

            //El operador elvis "?:" devuelve una lista vacia si no se recibe nada de la interfas que a su ves recibe de internet
                response.body() ?: emptyList()

        }
    }
}