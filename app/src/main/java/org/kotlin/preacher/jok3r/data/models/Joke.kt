package org.kotlin.preacher.jok3r.data.models


/**
 * Abstract class from which all jokes are subclassed  from
 */
abstract class Joke(category: Category, id: Int)

/**
 * Model class for two part jokes
 */
data class TwoPartJoke(
    var category: Category,
    var id: Int,
    val type: String = "twopart",
    var setup: String,
    var delivery: String
) : Joke(category, id)

/**
 * Model class for single jokes
 */
data class SingleJoke(
    var category: Category,
    var id: Int,
    val type: String = "single",
    var joke: String
) : Joke(category, id)