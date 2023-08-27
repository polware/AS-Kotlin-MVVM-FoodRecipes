package com.polware.foodrecipes.data.repositories

import com.polware.foodrecipes.data.network.LocalDataSource
import com.polware.foodrecipes.data.network.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

// The repository survives a configuration change: will have the same instance when user rotates the screen
@ActivityRetainedScoped
class Repository @Inject constructor(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) {
    val remoteData = remoteDataSource
    val localData = localDataSource

}