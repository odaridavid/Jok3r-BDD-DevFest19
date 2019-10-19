package org.kotlin.preacher.jok3r.data.source

import org.kotlin.preacher.jok3r.data.models.Category

interface PreferenceRepository {

    fun saveJokeCategoryPreference(category: Category)

    fun getJokeCategoryPreference(): Category

}