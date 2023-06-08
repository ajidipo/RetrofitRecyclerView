package com.example.latihanretrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("/albums")
    fun getAlbums(): Call<List<AlbumsItem>>
}