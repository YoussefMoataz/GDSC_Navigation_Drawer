package com.yquery.gdscnavigationdrawer.ui.test_two

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestTwoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Second Test Fragment"
    }
    val text: LiveData<String> = _text
}