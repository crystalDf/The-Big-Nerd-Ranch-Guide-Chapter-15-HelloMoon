package com.star.hellomoon;


import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Button;

public class AudioPlayer {

    private MediaPlayer mPlayer;

    public void stop(Button playButton) {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;

            playButton.setText(R.string.hellomoon_play);
        }
    }

    public void play(Context c, final Button playButton) {

        if (mPlayer == null) {

//            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
            mPlayer = MediaPlayer.create(c, R.raw.hugewave);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop(playButton);
                }
            });

            mPlayer.start();

            playButton.setText(R.string.hellomoon_pause);
        } else if (mPlayer.isPlaying()) {
            mPlayer.pause();

            playButton.setText(R.string.hellomoon_play);

        } else {
            mPlayer.start();

            playButton.setText(R.string.hellomoon_pause);
        }


    }

}
