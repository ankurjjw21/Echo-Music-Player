package com.example.ankurjhunjhunwala.echo

/**
 * Created by Ankur on 05-11-2017.
 */
class CurrentSongHelper {
    var songArtist: String? = null
    var songTitle: String? = null
    var songPath: String? = null
    var songID: Long? = 0
    var currentPosition: Int? = 0

    var isPlaying: Boolean = false
    var isShuffle: Boolean = false
    var isLoop: Boolean = false
    var trackPosition: Int = 0
}