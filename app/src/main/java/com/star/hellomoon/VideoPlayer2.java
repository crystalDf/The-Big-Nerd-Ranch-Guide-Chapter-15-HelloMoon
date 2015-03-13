package com.star.hellomoon;


import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Button;
import android.widget.VideoView;

public class VideoPlayer2 {

    private VideoView mPlayer;

    private Uri resourceUri = Uri.parse("android.resource://" +
            "com.star.hellomoon/raw/apollo_17_stroll");

    public void stop(Button playButton) {
        if (mPlayer != null) {
            mPlayer = null;

            playButton.setText(R.string.hellomoon_play);
        }
    }

    public void play(Context c, VideoView videoView, final Button playButton) {

        if (mPlayer == null) {

            mPlayer = videoView;
            mPlayer.setVideoURI(resourceUri);

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
