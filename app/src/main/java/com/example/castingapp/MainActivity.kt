

package com.example.castingapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.cast.framework.*


class MainActivity : AppCompatActivity() {

    private var mCastSession: CastSession? = null
    private lateinit var mSessionManager: SessionManager
    private val mSessionManagerListener: SessionManagerListener<CastSession> =
        SessionManagerListenerImpl()

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.browser, menu)
        CastButtonFactory.setUpMediaRouteButton(
            applicationContext,
            menu,
            R.id.media_route_menu_item
        )
        return true
    }


    private inner class SessionManagerListenerImpl : SessionManagerListener<CastSession> {
        override fun onSessionStarted(session: CastSession, sessionId: String) {
            invalidateOptionsMenu()
        }

        override fun onSessionResumed(session: CastSession, wasSuspended: Boolean) {
            invalidateOptionsMenu()
        }

        override fun onSessionEnded(session: CastSession, error: Int) {
            finish()
        }


        override fun onSessionEnding(p0: CastSession) {
            TODO("Not yet implemented")
        }

        override fun onSessionResumeFailed(p0: CastSession, p1: Int) {
            TODO("Not yet implemented")
        }

        override fun onSessionResuming(p0: CastSession, p1: String) {
            TODO("Not yet implemented")
        }

        override fun onSessionStartFailed(p0: CastSession, p1: Int) {
            TODO("Not yet implemented")
        }

        override fun onSessionStarting(p0: CastSession) {
            TODO("Not yet implemented")
        }

        override fun onSessionSuspended(p0: CastSession, p1: Int) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mCastContext = CastContext.getSharedInstance(this)

        mSessionManager = CastContext.getSharedInstance(this).sessionManager
    }
    override fun onResume() {
        super.onResume()
        mCastSession = mSessionManager.currentCastSession
        mSessionManager.addSessionManagerListener(mSessionManagerListener, CastSession::class.java)
    }

    override fun onPause() {
        super.onPause()
        mSessionManager.removeSessionManagerListener(mSessionManagerListener, CastSession::class.java)
        mCastSession = null
    }
}