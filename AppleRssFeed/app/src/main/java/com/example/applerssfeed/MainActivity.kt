@file:Suppress("DEPRECATION")

package com.example.applerssfeed

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.applerssfeed.Model.FeedEntry
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val download = Downloader(this, listView_Feed)
        download.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=25/xml")
    }


    //companion object is the kotlin way of making this class a static class so it doesnot have direct reference to parent class.

    // this is done to release the strong reference created when we created this inner class which cause problem of
    //memory leak. ex: when we close the main activity ,it may happen that any refernce of main activity if tied to
    //this class can prevent the object of this class from being garbage collected if it was in running state when we destroyed
    //mian activity.


    companion object {
        class Downloader(context:Context ,  list:ListView) : AsyncTask<String, Void, String>() {
            private val TAG = "Downloader"

            /* Strong reference is being created . this leaks a context object.
            var propContext:Context = context
            var propListView:ListView = list*/

            var propContext:Context by Delegates.notNull()
            var propListView:ListView by Delegates.notNull()

            init{
                propListView = list
                propContext = context
            }

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG, "doInBackground starts with: ${url.firstOrNull()?:""}")
                val rssFeed = downloadXML(url.firstOrNull()?:"")
                return rssFeed
            }

            override fun onPostExecute(result: String) {
                super.onPostExecute(result)
               Log.d(TAG, "onPostExecute")
                /*observation : It is mandatory to create a object and access the list through that only.*/
               var parseModule =  Parser()
                parseModule.parse(result)

                val arrayAdaptor =  ArrayAdapter<FeedEntry>(propContext,R.layout.list_item,parseModule.getListOfFeeds())
                propListView.adapter = arrayAdaptor
            }

            //            fun downloadXML(url: String): String {
//                var xmlResult = StringBuilder()
//                try {
//                    var urlPath = URL(url)
//                    //open the connection
//                    val connection: HttpURLConnection =
//                        urlPath.openConnection() as HttpURLConnection
//                    val responseCode = connection.responseCode
//                    Log.d(TAG, "downloadXML: ResponseCode: $responseCode")
//
////                    val inputStream = connection.inputStream
////                    val inputStreamReader = InputStreamReader(inputStream)
////                    //we will use a buffered reader to get the content
////                    val reader = BufferedReader(inputStreamReader)
//
//
//                    //we can chain these so that on closing buffered reader it will automatically close other io streams
////                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
////
////                    val buffer = CharArray(500)
////                    var charRead = 0
////                    while(charRead >= 0){
////                        charRead = reader.read(buffer)  //return the count of chars read .
////                        if(charRead > 0){
////                            xmlResult = xmlResult.append(String(buffer,0,charRead))
////                        }
////                    }
////
////                    reader.close()
//
//                    //lets use functional programming to replace above lines of code
//                    val stream = connection.inputStream
//                    stream.buffered().reader().use { reader->
//                        xmlResult.append(reader.readText())
//                    }
//
//                    Log.d(TAG, "downloadXML: XMLResult : ${xmlResult.length} bytes")
//                    return  xmlResult.toString()
//
//                } catch (e:Exception){
//                    var errorMessage:String = "No Exception";
//                    when(e){
//                        is MalformedURLException -> errorMessage = "Malformed URL Error."
//                        is IOException -> errorMessage = "IO Error while reading data."
//                        is SecurityException -> errorMessage = e.message.toString()
//                        else -> errorMessage = e.message.toString()
//                    }
//                    Log.e(TAG, "downloadXML: $errorMessage")
//                }
//                return "" //if code reaches here there is some error in fetching data.
//            }
//        }
//    }
            private fun downloadXML(url: String): String {
                    return URL(url).readText()
            }
        }
    }
}