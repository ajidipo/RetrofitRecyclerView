package com.example.latihanretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanretrofit.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var rvData : RecyclerView
    lateinit var AlbumAdapter:AlbumAdapter

    var BASE_URL = "https://jsonplaceholder.typicode.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvData = findViewById(R.id.rvData)

        rvData.layoutManager = LinearLayoutManager(this)
        getAllData()

    }

    private fun getAllData(){
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AlbumService::class.java)

        var retroData = retrofit.getAlbums()

        retroData.enqueue(object :Callback<List<AlbumsItem>>{
            override fun onResponse(
                call: Call<List<AlbumsItem>>,
                response: Response<List<AlbumsItem>>
            ) {
                var data = response.body()!!

                AlbumAdapter = AlbumAdapter(baseContext,data)

                rvData.adapter = AlbumAdapter

                Log.d("data",data.toString())
            }

            override fun onFailure(call: Call<List<AlbumsItem>>, t: Throwable) {

            }

        })
    }

}