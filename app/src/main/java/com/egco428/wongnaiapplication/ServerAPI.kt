package com.egco428.wongnaiapplication

import io.reactivex.Observable
import retrofit2.http.*
import java.util.*

//Simulate data class for only test before backend create real API finish
interface ServerAPI {

    @Headers("Content-Type: application/json;charset=utf-8")
    @GET("coins")
    fun getData(): Observable<ResponseData>


}