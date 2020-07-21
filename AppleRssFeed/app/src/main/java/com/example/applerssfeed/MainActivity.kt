package com.example.applerssfeed

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.io.*
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var download = Downloader()
        download.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=10/xml")
    }


    //companion object is the kotlin way of making this class a static class so it doesnot have direct reference to parent class.

    // this is done to release the strong reference created when we created this inner class which cause problem of
    //memory leak. ex: when we close the main activity ,it may happen that any refernce of main activity if tied to
    //this class can prevent the object of this class from being garbage collected if it was in running state when we destroyed
    //mian activity.


    companion object {
        class Downloader : AsyncTask<String, Void, String>() {
            private val TAG = "Downloader"
            override fun onPreExecute() {
                super.onPreExecute()

            }

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG, "doInBackground starts with: ${(url[0]).toString()}")
                val rssFeed = downloadXML(url[0]!!)
                return rssFeed
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                Log.d(TAG, "onPostExecute: Result is : $result")
            }

            fun downloadXML(url: String): String {
                var xmlResult = StringBuilder()
                try {
                    var urlPath = URL(url)
                    //open the connection
                    val connection: HttpURLConnection =
                        urlPath.openConnection() as HttpURLConnection
                    val responseCode = connection.responseCode
                    Log.d(TAG, "downloadXML: ResponseCode: $responseCode")

//                    val inputStream = connection.inputStream
//                    val inputStreamReader = InputStreamReader(inputStream)
//                    //we will use a buffered reader to get the content
//                    val reader = BufferedReader(inputStreamReader)


                    //we can chain these so that on closing buffered reader it will automatically close other io streams
                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
                    
                    val buffer = CharArray(500)
                    var charRead = 0
                    while(charRead >= 0){
                        charRead = reader.read(buffer)  //return the count of chars read .
                        if(charRead > 0){
                            xmlResult = xmlResult.append(String(buffer,0,charRead))
                        }
                    }

                    reader.close()

                    Log.d(TAG, "downloadXML: XMLResult : ${xmlResult.length} bytes")
                    return  xmlResult.toString()

                } catch (e: MalformedURLException) {
                    Log.e(TAG, "downloadXML:Malformed  URL:: ${e.message}")
                } catch (e: IOException) {
                    Log.e(TAG, "downloadXML: IO error during reading data:: ${e.message}")

                    e.printStackTrace()
                } catch (e: Exception) {
                    Log.e(TAG, "downloadXML: Unknown Error: ${e.message}")
                }

                return "" //if code reaches here there is some error in fetching data.
            }
        }
    }

}