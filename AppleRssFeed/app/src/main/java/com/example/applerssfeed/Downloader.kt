package com.example.applerssfeed

import android.content.Context
import android.os.AsyncTask
import android.widget.ListView
import android.widget.TextView
import java.net.URL
import kotlin.properties.Delegates


@Suppress("DEPRECATION")
class Downloader(context: Context, list: ListView, title: TextView) :
    AsyncTask<String, Void, String>() {
    private val TAG = "Downloader"

    /* Strong reference is being created . this leaks a context object.
    var propContext:Context = context
    var propListView:ListView = list*/

    var propContext: Context by Delegates.notNull()
    var propListView: ListView by Delegates.notNull()
    var propTitle: TextView by Delegates.notNull()


    init {
        propListView = list
        propContext = context
        propTitle = title
    }

    override fun doInBackground(vararg url: String?): String {
//                Log.d(TAG, "doInBackground starts with: ${url.firstOrNull() ?: ""}")
        val rssFeed = downloadXML(url.firstOrNull() ?: "")
        return rssFeed
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)

        /*observation : It is mandatory to create a object and access the list through that only.*/
        val parseModule = XmlParser()
        parseModule.parse(result)

        propTitle.text = parseModule.feedTitle
        /*Using Custom Adapter*/
        val feedAdapter =
            FeedAdapter(propContext, R.layout.list_record, parseModule.application)
        propListView.adapter = feedAdapter
    }


    private fun downloadXML(url: String): String {
        return URL(url).readText()
    }
}
