package com.star.hellomoon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class HelloMoonFragment2 extends Fragment {

    private VideoPlayer2 mPlayer = new VideoPlayer2();

    private VideoView mVideoView;
    private MediaController mMediaController;

    private Button mPlayButton;
    private Button mStopButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hello_moon2, container, false);

        mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPlayer.play(getActivity(), mVideoView, mPlayButton);
            }
        });

        mStopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPlayer.stop(mPlayButton);
            }
        });

        mVideoView = (VideoView) v.findViewById(R.id.hellomoon_VideoView);
        mMediaController = new MediaController(getActivity());
        mVideoView.setMediaController(mMediaController);

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop(mPlayButton);
    }
}
