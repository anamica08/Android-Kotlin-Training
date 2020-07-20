package com.example.retrofitpostapp.API

import com.example.retrofitpostapp.Model.Comment
import com.example.retrofitpostapp.Model.Post
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @GET("posts")
    fun getPosts():Call<List<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") postId:Int):Call<Post>

    @GET("posts/{id}/comments")
    fun getCommentsForPost(@Path("id") postId: Int):Call<List<Comment>>

//    @GET("comments")
//    fun getComments(@Query("postId") id:Int):Call<List<Comment>>
//
//    @GET("comments")
//    fun getComments(@Query("postId") id:Int,@Query("_order") order:String):Call<List<Comment>>

    @GET("comments")
    fun getComments(@Query("postId") id:Int, @Query("_order") order: String?, @Query("_sort") sort:String?):Call<List<Comment>>
    //one more way to write this method

    @GET("comments")
    fun getComments(@QueryMap parameters:Map<String,String>):Call<List<Comment>>

    @POST("posts")
    fun creatPost(@Body post:Post):Call<Post>

    @PUT("posts/{id}")
    fun updatePost(@Path("id") post_id:Int,@Body post:Post):Call<Post>

}