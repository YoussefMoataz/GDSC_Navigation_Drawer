package com.yquery.gdscnavigationdrawer.ui.test_one

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestOneViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is First Test Fragment"
    }
    val text: LiveData<String> = _text
}