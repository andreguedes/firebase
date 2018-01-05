package br.com.andreguedes.firebaseremoteconfig

import android.app.Application
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.storage.FirebaseStorage


/**
 * Created by andreguedes on 03/01/18.
 */
class RemoteConfigApplication : Application() {

    lateinit var remoteConfig: FirebaseRemoteConfig
    lateinit var storage: FirebaseStorage

    override fun onCreate() {
        super.onCreate()

        initFirebaseRemoteConfig()
        initFirebaseStorage()
    }

    private fun initFirebaseRemoteConfig() {
        remoteConfig = FirebaseRemoteConfig.getInstance()
        val firebaseRemoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build()
        remoteConfig.setConfigSettings(firebaseRemoteConfigSettings)
    }

    private fun initFirebaseStorage() {
        storage = FirebaseStorage.getInstance()
    }

}