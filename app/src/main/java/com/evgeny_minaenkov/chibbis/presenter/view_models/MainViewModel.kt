package com.evgeny_minaenkov.chibbis.presenter.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgeny_minaenkov.chibbis.data.model.hits.HitsResponse
import com.evgeny_minaenkov.chibbis.data.model.restaurats.RestaurantsResponse
import com.evgeny_minaenkov.chibbis.data.model.reviews.ReviewsResponse
import com.evgeny_minaenkov.chibbis.data.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = RepositoryImpl()

    private val _restaurants: MutableLiveData<RestaurantsResponse> = MutableLiveData()
    val restaurants: LiveData<RestaurantsResponse> = _restaurants

    private val _hits: MutableLiveData<HitsResponse> = MutableLiveData()
    val hits: LiveData<HitsResponse> = _hits

    private val _reviews: MutableLiveData<ReviewsResponse> = MutableLiveData()
    val reviews: LiveData<ReviewsResponse> = _reviews

    init {
        getRestaurants()
        getHits()
        getReviews()
    }

    private fun getRestaurants(){
        viewModelScope.launch(IO) {
            _restaurants.postValue(repository.getRestaurants())
        }
    }

    private fun getHits(){
        viewModelScope.launch(IO) {
            _hits.postValue(repository.getHits())

        }
    }

    private fun getReviews(){
        viewModelScope.launch(IO) {
            _reviews.postValue(repository.getReviews())

        }
    }
}