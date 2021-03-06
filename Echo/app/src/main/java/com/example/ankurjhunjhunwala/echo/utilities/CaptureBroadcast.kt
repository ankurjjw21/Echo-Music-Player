package com.example.ankurjhunjhunwala.echo.utilities

import android.app.Service
import android.bluetooth.BluetoothClass
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import com.example.ankurjhunjhunwala.echo.R
import com.example.ankurjhunjhunwala.echo.activities.MainActivity
import com.example.ankurjhunjhunwala.echo.fragments.SongPlayingFragment

/**
 * Created by Ankur on 10-11-2017.
 */
class CaptureBroadcast : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1?.action == Intent.ACTION_NEW_OUTGOING_CALL) {
            try {
                MainActivity.Statified.notificationManager?.cancel(1996)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            try {
                if (SongPlayingFragment.Statified.mediaplayer?.isPlaying as Boolean) {
                    SongPlayingFragment.Statified.mediaplayer?.pause()
                    SongPlayingFragment.Statified.playPauseImageButton?.setBackgroundResource(R.drawable.play_icon)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            val tm: TelephonyManager = p0?.getSystemService(Service.TELEPHONY_SERVICE) as TelephonyManager
            when (tm?.callState) {
                TelephonyManager.CALL_STATE_RINGING -> {
                    try {
                        MainActivity.Statified.notificationManager?.cancel(1996)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    try {
                        if (SongPlayingFragment.Statified.mediaplayer?.isPlaying as Boolean) {
                            SongPlayingFragment.Statified.mediaplayer?.pause()
                            SongPlayingFragment.Statified.playPauseImageButton?.setBackgroundResource(R.drawable.play_icon)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
                else -> {

                }
            }
        }
    }

}