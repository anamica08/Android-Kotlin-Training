@file:Suppress("DEPRECATION")

package com.example.applerssfeed

import android.content.Context
import android.icu.text.CaseMap
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    //Make sure to add lazy initlialisation . because we are referring to view before setContentLayout
    private var downloader: Downloader? = null
    private var feedLimit: Int = 10
    var feedURL: String = UrlGenerator()
        .getUrl(feedLimit, AppCategory.SONGS)

    private var feedChachedURL = "INVALIDATE"
    private val STATE_URL = "feedURL"
    private val STATE_LIMIT = "feedLimit"

    private lateinit var title:String

    /**
     * onCreate
     * starts the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            //Log.d(TAG, "onCreate: Bundle Restored")
            feedLimit = savedInstanceState.getInt(STATE_LIMIT)
            feedURL = savedInstanceState.getString(STATE_URL).toString()
        }

        downloadURL(feedURL)
    }

    /*
    * initiates the ASYNCTASK to start downloading in background thread
    * */
    private fun downloadURL(feedUrl: String) {
        if (feedUrl != feedChachedURL) {
            downloader = Downloader(this, listView_Feed,tv_title)
            feedChachedURL = feedUrl
            downloader!!.execute(feedUrl)
        }

    }


    /**
     * Inflates the Menu on View.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.feeds_menu, menu)
        if (feedLimit == 10) {
            menu?.findItem(R.id.ten)?.isChecked = true
        } else {
            menu?.findItem(R.id.twentyfive)?.isChecked = true
        }
        return true
    }

    /**
     * OnItemSelected Event Listener
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnufree -> {
                feedURL = UrlGenerator()
                    .getUrl(feedLimit, AppCategory.FREE_APPS)
            }
            R.id.mnuAlbums -> {
                feedURL = UrlGenerator().getUrl(feedLimit, AppCategory.ALBUMS)
            }
            R.id.mnupaid -> {
                feedURL = UrlGenerator()
                    .getUrl(feedLimit, AppCategory.PAID_APPS)
            }
            R.id.mnusongs -> {
                feedURL = UrlGenerator()
                    .getUrl(feedLimit, AppCategory.SONGS)
            }
            R.id.ten, R.id.twentyfive -> {
                if (!item.isChecked) {
                    item.isChecked = true
                    feedLimit = 35 - feedLimit
                }
            }
            R.id.mnuRefresh -> feedChachedURL = "INVALIDATE"
            else -> return super.onOptionsItemSelected(item)
        }
        downloadURL(feedURL)
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //Log.d(TAG, "onSaveInstanceState: Feed URL : $feedURL and Feed Limit : $feedLimit saved")
        outState.putString(STATE_URL, feedURL)
        outState.putInt(STATE_LIMIT, feedLimit)

    }


    override fun onDestroy() {
        super.onDestroy()
        //Log.d(TAG, "onDestroy: Activity destroyed")
        downloader?.cancel(true)
    }


    /*companion object is the kotlin way of making this class a static class so it doesnot have direct reference to parent class.

     this is done to release the strong reference created when we created this inner class which cause problem of
    memory leak. ex: when we close the main activity ,it may happen that any refernce of main activity if tied to
    this class can prevent the object of this class from being garbage collected if it was in running state when we destroyed
    main activity
   .*/

    /*Downloader Class*/
    companion object {
        private class Downloader(context: Context, list: ListView , title: TextView) :
            AsyncTask<String, Void, String>() {
            private val TAG = "Downloader"

            /* Strong reference is being created . this leaks a context object.
            var propContext:Context = context
            var propListView:ListView = list*/

            var propContext: Context by Delegates.notNull()
            var propListView: ListView by Delegates.notNull()
            var propTitle:TextView by Delegates.notNull()


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
    }
}