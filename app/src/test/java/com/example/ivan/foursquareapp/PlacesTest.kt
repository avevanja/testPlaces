package com.example.ivan.foursquareapp

import com.example.ivan.foursquareapp.entity.PlacesDataResponse
import com.example.ivan.foursquareapp.entity.PlacesResponse
import com.example.ivan.foursquareapp.model.repository.PlaceRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.util.*


class PlacesTest {
    private lateinit var testPlaceRepo: PlaceRepository
    private val testParams = HashMap<String, String>()
    private lateinit var testPlaces: PlacesResponse
    private lateinit var testError: Throwable


    @Before
    fun setUp() {
        testPlaces = PlacesResponse(PlacesDataResponse(null))
        testPlaceRepo = Mockito.mock(PlaceRepository::class.java)
        testError =  RuntimeException("test error")
    }

    @Test
    fun get_places() {
        Mockito.`when`(testPlaceRepo.getPlaces(testParams)).thenReturn(Single.just(testPlaces))
        val testObserver: TestObserver<PlacesResponse> = testPlaceRepo.getPlaces(testParams).test()
        testObserver.awaitTerminalEvent()
        Mockito.verify(testPlaceRepo).getPlaces(testParams)
        testObserver
                .assertValueCount(1)
                .assertValue(testPlaces)
                .assertNoErrors()
    }

    @Test
    fun get_places_error() {
        Mockito.`when`(testPlaceRepo.getPlaces(testParams)).thenReturn(Single.error(testError))
        val testObserver: TestObserver<PlacesResponse> = testPlaceRepo.getPlaces(testParams).test()
        testObserver.awaitTerminalEvent()
        Mockito.verify(testPlaceRepo).getPlaces(testParams)
        testObserver
                .assertNoValues()
                .assertError(testError)
    }
}