package com.example.retrofitpostapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitpostapp.API.ApiInterface
import com.example.retrofitpostapp.Model.Comment
import com.example.retrofitpostapp.Model.Post
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
        getAllPosts()
        //getPostByid(1)
        //getComments()
        //createPost()
        updatePost()

    }

    private fun getAllPosts() {
        var call: Call<List<Post>> = apiInterface.getPosts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                textViewResult.setText(t!!.message.toString())
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                var list: List<Post> = response!!.body()!!
                //Log.d("Body",list.count().toString())
                for (post in list) {
                    var content = " "
                    content += "\n Id: ${post.id}"
                    content += "\n User Id: ${post.userId}"
                    content += "\n Title: ${post.Heading}"
                    content += "\n Body: ${post.Text}\n\n"

                    textViewResult.append(content)
                }
            }
        })
    }

    private fun getPostByid(id: Int){
        var call: Call<Post> = apiInterface.getPostById(id)

        call.enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                textViewResult.setText(t!!.message)
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                var content: Post = response!!.body()!!
                //Log.d("Body",content.toString())
                textViewResult.setText(content.toString())


            }

        })


    }

//    private fun getComments(id: Int) {
//        var call: Call<List<Comment>> = apiInterface.getCommentsForPost(id)
//        call.enqueue(object : Callback<List<Comment>> {
//            override fun onFailure(call: Call<List<Comment>>?, t: Throwable?) {
//                textViewResult.setText(t!!.message)
//            }
//
//            override fun onResponse(
//                call: Call<List<Comment>>?,
//                response: Response<List<Comment>>?
//            ) {
//                var comments:List<Comment> = response!!.body()!!
//                for(comment in comments){
//                    var content =" "
//                    content += "\nPost Id: ${comment.postId}"
//                    content += "\nComment Id: ${comment.commentId}"
//                    content += "\nName: ${comment.name}"
//                    content += "\nEmail: ${comment.email}"
//                    content += "\nBody: ${comment.body}\n\n\n"
//
//                    textViewResult.append(content)
//                }
//            }
//        })
//
//    }
private fun getComments() {
    //var call: Call<List<Comment>> = apiInterface.getComments(3,"desc","id")
    //var call: Call<List<Comment>> = apiInterface.getComments(3,null,null)
    var mapOfParamaters = mapOf<String,String>("postId" to "3","_order" to "desc","_sort" to "id")
    var call:Call<List<Comment>> = apiInterface.getComments(mapOfParamaters)
    call.enqueue(object : Callback<List<Comment>> {
        override fun onFailure(call: Call<List<Comment>>?, t: Throwable?) {
            textViewResult.setText(t!!.message)
        }

        override fun onResponse(
            call: Call<List<Comment>>?,
            response: Response<List<Comment>>?
        ) {
            var comments:List<Comment> = response!!.body()!!
            for(comment in comments){
                var content =" "
                content += "\nPost Id: ${comment.postId}"
                content += "\nComment Id: ${comment.commentId}"
                content += "\nName: ${comment.name}"
                content += "\nEmail: ${comment.email}"
                content += "\nBody: ${comment.body}\n\n\n"
                content += "\n***************************************************\n"

                textViewResult.append(content)
            }
        }
    })

}

    private fun createPost(){
        val post:Post = Post(1,null,"Anamika's Post","This is test post created to check.")

        val call:Call<Post> = apiInterface.creatPost(post)

        call.enqueue(object:Callback<Post>{
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                textViewResult.append(t!!.message)
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
               textViewResult.append(
                   "\n\n\n\n\nCreated Post is: ${response!!.body()} "
               )
            }

        })
    }


    private fun updatePost(){
        var postToUpdate:Post = Post(1,1,"updated heading","updated content")
        var call:Call<Post> = apiInterface.updatePost(1,postToUpdate)
        call.enqueue(object :Callback<Post>{
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                textViewResult.append(t!!.message)
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                textViewResult.append(response!!.body().toString())
            }

        })
    }
}