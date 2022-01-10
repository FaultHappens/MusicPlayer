package com.example.musicplayer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var playBttn: Button
    private var isPlaying: Boolean = false
    private lateinit var seekBar: SeekBar
    private lateinit var musicProgressionTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        playBttn = binding.playBttn
        seekBar = binding.seekBar
        musicProgressionTV = binding.progressPercentageTV
        playBttn.setOnClickListener {
            if (isPlaying) {
                isPlaying = !isPlaying
                stopService(Intent(this, MusicService::class.java))
            }else{
                isPlaying = !isPlaying
                startService(Intent(this, MusicService::class.java))
            }
        }
        seekBar.setOnSeekBarChangeListener(object :
            OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
//                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//                    mediaPlayer.seekTo(seekBar.getProgress());
//                }
                binding.progressPercentageTV.text = seek.progress.toString() + "%"
            }
        })
    }
}