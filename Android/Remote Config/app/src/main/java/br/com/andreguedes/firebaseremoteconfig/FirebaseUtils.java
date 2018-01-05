package br.com.andreguedes.firebaseremoteconfig;

import android.app.Activity;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by andreguedes on 28/12/17.
 */

public class FirebaseUtils {

    public static final String TESTE = "teste";

    public static void fetchFirebase(Activity activity) {
        FirebaseRemoteConfig mFirebaseRemoteConfig = getFirebaseRemoteConfig(activity);

        long cacheExpiration = 3600;
//        if (mFirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
//            cacheExpiration = 0;
//        }

        mFirebaseRemoteConfig.fetch(cacheExpiration)
                .addOnCompleteListener(activity, task -> {
                    if (task.isSuccessful()) {
                        mFirebaseRemoteConfig.activateFetched();
                    }
                });
    }

    public static String getConfigString(Activity activity, String key) {
        FirebaseRemoteConfig mFirebaseRemoteConfig = getFirebaseRemoteConfig(activity);
        return mFirebaseRemoteConfig.getString(key);
    }

    public static StorageReference getImage(Activity activity) {
        FirebaseStorage firebaseStorage = getStorageReference(activity);
        return firebaseStorage.getReferenceFromUrl("gs://remote-config-fdd06.appspot.com/bola.jpg");
    }

    private static FirebaseStorage getStorageReference(Activity activity) {
        return ((RemoteConfigApplication) activity.getApplication()).getStorage();
    }

    private static FirebaseRemoteConfig getFirebaseRemoteConfig(Activity activity) {
        return ((RemoteConfigApplication) activity.getApplication()).getRemoteConfig();
    }

}