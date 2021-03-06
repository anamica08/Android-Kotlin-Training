package com.example.applerssfeed

import android.util.Log
import com.example.applerssfeed.Model.FeedEntry
import org.xmlpull.v1.XmlPullParser
import java.lang.Exception
import  org.xmlpull.v1.XmlPullParserFactory

public class XmlParser {
    private val TAG = "Parser"

    var feedTitle = "Top 10 Songs"
        private set

    val application = ArrayList<FeedEntry>()

    fun getListOfFeeds(): ArrayList<FeedEntry> {
        return application
    }

    fun parse(xmlData: String): Boolean {

        var status = true
        var textValue = ""
        var inEntry = false

        try {
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val xpp = factory.newPullParser()
            xpp.setInput(xmlData.reader())

            var eventType = xpp.eventType

            var currentRecord = FeedEntry()
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = xpp.name?.toLowerCase()
                // Log.d(TAG, "parse: xpp.name() = $tagName")

                when (eventType) {

                    XmlPullParser.START_TAG -> {
                         //Log.d(TAG, "parse: Starting Tag: $tagName")
                        // if tag is Entry tag then inEntry = true signals that the parser has reached into entry tag.
                        if (tagName == "entry") {
                            inEntry = true
                        }
                    }
                    // below line will read data into textValue irrespective of the tag name.
                    XmlPullParser.TEXT -> textValue = xpp.text

                    //we will check if inEntry is true and end tag is Entry then the data read into textValue is of
                    //our intrest and thus we will serialise to FeedEntry object.

                    XmlPullParser.END_TAG -> {
                        //Log.d(TAG, "parse: Ending Tag: $tagName")
                        if(tagName == "title" && inEntry == false){
                            feedTitle = textValue
                            Log.d(TAG, "parse: Title set to $feedTitle and $textValue")
                        }
                        if (inEntry) {
                            when (tagName) {
                                "entry" -> {
                                    application.add(currentRecord)
                                    inEntry = false
                                    currentRecord = FeedEntry()   // create a new object
                                }

                                "name" -> currentRecord.name = textValue
                                "artist" -> currentRecord.artist = textValue
                                "releasedate" -> currentRecord.releaseDate = textValue
                                "image" -> currentRecord.imageURL = textValue
                            }
                        }
                    }

                }
                //next to other event
                eventType = xpp.next()

            }
            Log.d(TAG, "parse: Feed Title: $feedTitle")

//            for (app in application) {
//                Log.d(TAG,"*******************")
//                Log.d(TAG,app.toString())
//            }
        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }
        return status
    }

}