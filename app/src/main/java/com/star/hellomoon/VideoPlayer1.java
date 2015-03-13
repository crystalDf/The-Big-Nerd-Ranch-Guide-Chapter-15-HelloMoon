package com.star.hellomoon;


import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.widget.Button;

import java.io.IOException;

public class VideoPlayer1 {

    private MediaPlayer mPlayer;

    private Uri resourceUri = Uri.parse("android.resource://" +
            "com.star.hellomoon/raw/apollo_17_stroll");

    public void stop(Button playButton) {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;

            playButton.setText(R.string.hellomoon_play);
        }
    }

    public void play(Context c, SurfaceHolder holder, final Button playButton) {

        if (mPlayer == null) {

//            mPlayer = MediaPlayer.create(c, R.raw.sample_mpeg4);

            mPlayer = new MediaPlayer();

            try {
                mPlayer.setDataSource(c, resourceUri);

                mPlayer.setDisplay(holder);

                mPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
