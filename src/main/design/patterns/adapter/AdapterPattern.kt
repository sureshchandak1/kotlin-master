package adapter

/*
*  adapter pattern is that it allows classes with incompatible interfaces to work together
* */

fun main() {

    val audioPlayer = AudioPlayer()

    audioPlayer.play("mp3", "fetch_water.mp3")
    audioPlayer.play("mp4", "get_lost.mp4")
    audioPlayer.play("vlc", "life_lessons.vlc")
    audioPlayer.play("avi", "still_waters.avi")
}

private interface MediaPlayer {
    fun play(audioType: String, fileName: String)
}

private interface AdvancedMediaPlayer {
    fun playVlc(fileName: String)
    fun playMp4(fileName: String)
}

private class VlcPlayer : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Playing vlc file. Name: $fileName")
    }

    override fun playMp4(fileName: String) {
    }
}

private class Mp4Player : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
    }

    override fun playMp4(fileName: String) {
        println("Playing mp4 file. Name: $fileName")
    }
}

private class MediaAdapter(audioType: String) : MediaPlayer {
    private var advancedMediaPlayer: AdvancedMediaPlayer? = null

    init {
        if (audioType.equals("vlc", true)) {
            advancedMediaPlayer = VlcPlayer()
        } else if (audioType.equals("mp4", true)) {
            advancedMediaPlayer = Mp4Player()
        }
    }

    override fun play(audioType: String, fileName: String) {
        if (audioType.equals("vlc", true)) {
            advancedMediaPlayer?.playVlc(fileName)
        } else if (audioType.equals("mp4", true)) {
            advancedMediaPlayer?.playMp4(fileName)
        }
    }
}

private class AudioPlayer : MediaPlayer {
    private var mediaAdapter: MediaAdapter? = null

    override fun play(audioType: String, fileName: String) {
        if (audioType.equals("mp3", true)) {
            println("Playing mp3 file. Name: $fileName")
        } else if (audioType.equals("vlc", true) || audioType.equals("mp4", true)) {
            mediaAdapter = MediaAdapter(audioType)
            mediaAdapter?.play(audioType, fileName)
        } else {
            println("Invalid media. $audioType format not supported")
        }
    }
}


