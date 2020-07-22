package com.example.applerssfeed.Model

class FeedEntry(var name:String = "" , var artist:String = "",var releaseDate:String = "",var imageURL:String = ""){

    override fun toString(): String {
        return """
            Name: $name
            Artist: $artist
            Date of Release: $releaseDate
            ImageURL: ${this.imageURL}
        """
    }
}