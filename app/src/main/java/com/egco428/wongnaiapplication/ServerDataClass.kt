package com.egco428.wongnaiapplication

import com.google.gson.annotations.SerializedName

//Simulate data class for only test before backend create real API finish

data class ResponseData(

    @SerializedName("status") val status : String,
    @SerializedName("data") val data : Data
)

data class Data (

    @SerializedName("stats") val stats : Stats,
    @SerializedName("base") val base : Base,
    @SerializedName("coins") val coins : ArrayList<Coins>
)

data class Stats (

    @SerializedName("total") val total : Int,
    @SerializedName("offset") val offset : Int,
    @SerializedName("limit") val limit : Int,
    @SerializedName("order") val order : String,
    @SerializedName("base") val base : String,
    @SerializedName("totalMarkets") val totalMarkets : Int,
    @SerializedName("totalExchanges") val totalExchanges : Int,
    @SerializedName("totalMarketCap") val totalMarketCap : Double,
    @SerializedName("total24hVolume") val total24hVolume : Double
)


data class Base (

    @SerializedName("symbol") val symbol : String,
    @SerializedName("sign") val sign : String
)

data class Coins (

    @SerializedName("id") val id : Int,
    @SerializedName("uuid") val uuid : String,
    @SerializedName("slug") val slug : String,
    @SerializedName("symbol") val symbol : String,
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String?,
    @SerializedName("color") val color : String,
    @SerializedName("iconType") val iconType : String,
    @SerializedName("iconUrl") val iconUrl : String,
    @SerializedName("websiteUrl") val websiteUrl : String,
    @SerializedName("socials") val socials : List<Socials>,
    @SerializedName("links") val links : List<Links>,
    @SerializedName("confirmedSupply") val confirmedSupply : Boolean,
    @SerializedName("numberOfMarkets") val numberOfMarkets : Int,
    @SerializedName("numberOfExchanges") val numberOfExchanges : Int,
    @SerializedName("type") val type : String,
    @SerializedName("volume") val volume : Long,
    @SerializedName("marketCap") val marketCap : Long,
    @SerializedName("price") val price : Double,
    @SerializedName("circulatingSupply") val circulatingSupply : Double,
    @SerializedName("totalSupply") val totalSupply : Double,
    @SerializedName("approvedSupply") val approvedSupply : Boolean,
    @SerializedName("firstSeen") val firstSeen : Long,
    @SerializedName("change") val change : Double,
    @SerializedName("rank") val rank : Int,
    @SerializedName("history") val history : List<Double>,
    @SerializedName("allTimeHigh") val allTimeHigh : AllTimeHigh,
    @SerializedName("penalty") val penalty : Boolean
)

data class Socials (

    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String,
    @SerializedName("type") val type : String
)


data class Links (

    @SerializedName("name") val name : String,
    @SerializedName("type") val type : String,
    @SerializedName("url") val url : String
)

data class AllTimeHigh (

    @SerializedName("price") val price : Double,
    @SerializedName("timestamp") val timestamp : Long
)