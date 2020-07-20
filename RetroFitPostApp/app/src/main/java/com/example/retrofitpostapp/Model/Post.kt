package com.example.retrofitpostapp.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class Post ( val userId:Int,val id:Int?,  @SerializedName("title") var Heading:String, @SerializedName("body") var Text:String){

 }

//here id is made nullable because while doing post request , id for that post will be generated automatically.
//by doing nullable , JSON will not contain id at all.