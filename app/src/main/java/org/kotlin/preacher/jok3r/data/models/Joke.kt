package org.kotlin.preacher.jok3r.data.models

import com.google.gson.annotations.SerializedName


open class Joke(
    @SerializedName("type") val jokeType: String,
    @SerializedName("category") val jokeCategory: String,
    @SerializedName("id") val jokeId: Int,
    @SerializedName("joke") var singleJoke: String? = null,
    @SerializedName("setup") var twoPartsetup: String? = null,
    @SerializedName("delivery") var twoPartdelivery: String? = null
)

/**
 * Model class for two part jokes
 */
data class TwoPartJoke(
    var category: String,
    var id: Int,
    val type: String = JokeType.TWO_PART.name,
    var setup: String,
    var delivery: String
) : Joke(type, category, id, twoPartsetup = setup, twoPartdelivery = delivery)

/**
 * Model class for single jokes
 */
data class SingleJoke(
    var category:String,
    var id: Int,
    val type: String = JokeType.SINGLE.name,
    var joke: String
) : Joke(type, category, id, singleJoke = joke)