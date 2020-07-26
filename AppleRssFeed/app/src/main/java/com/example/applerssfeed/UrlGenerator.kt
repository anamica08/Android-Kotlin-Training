package com.example.applerssfeed



class UrlGenerator {

    fun getUrl(count:Int, category: AppCategory):String{

        val url = when(category){
            AppCategory.FREE_APPS -> "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=$count/xml"
            AppCategory.PAID_APPS -> "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/toppaidapplications/limit=$count/xml"
            AppCategory.SONGS -> "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=$count/xml"
            AppCategory.ALBUMS -> "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topalbums/limit=$count/xml"

        }
        //Log.d("New URL generated",url)
    return url
    }

}