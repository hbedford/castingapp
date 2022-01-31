package com.example.castingapp

import android.content.Context
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.OptionsProvider
import com.google.android.gms.cast.framework.SessionProvider

class CastOptionsProvider : OptionsProvider {
    companion object {
        const val CUSTOM_NAMESPACE = "urn:x-cast:com.example.castingapp"

//        const val CUSTOM_NAMESPACE = "urn:x-cast:custom_namespace"
    }

    override fun getCastOptions(appContext: Context): CastOptions {
        val supportedNamespaces: MutableList<String> = ArrayList()
        supportedNamespaces.add(CUSTOM_NAMESPACE)

        return CastOptions.Builder()

            .setReceiverApplicationId(appContext.getString(R.string.app_id))
//            .setSupportedNamespaces(supportedNamespaces)
            .setEnableReconnectionService(true)

            .build()
    }

    override fun getAdditionalSessionProviders(context: Context): List<SessionProvider>? {
        return null
    }
}