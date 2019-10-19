package org.kotlin.preacher.jok3r.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.kotlin.preacher.jok3r.data.Error
import org.kotlin.preacher.jok3r.data.Success
import org.kotlin.preacher.jok3r.data.models.Category
import org.kotlin.preacher.jok3r.data.models.SingleJoke
import org.kotlin.preacher.jok3r.data.models.TwoPartJoke
import org.kotlin.preacher.jok3r.data.source.JokesRepository

class JokesViewModel(private val jokesRepository: JokesRepository) : ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _errorResponse: MutableLiveData<String> = MutableLiveData()
    val errorResponse: LiveData<String>
        get() = _errorResponse

    private val _jokeContent: MutableLiveData<String> = MutableLiveData()
    val jokeContent: LiveData<String>
        get() = _jokeContent

    fun getJoke() {
        _isLoading.value = true
        viewModelScope.launch {
            val joke = jokesRepository.getJoke(Category.PROGRAMMING.name)
            if (joke is Success) {
                when (val data = joke.data) {
                    is SingleJoke -> {
                        _jokeContent.value = data.joke
                    }
                    is TwoPartJoke -> {
                        _jokeContent.value = "${data.setup} \n ${data.delivery}"
                    }
                }
            } else if(joke is Error) {
                _errorResponse.value = joke.exception.message

            }
            _isLoading.value = false

        }

    }
}