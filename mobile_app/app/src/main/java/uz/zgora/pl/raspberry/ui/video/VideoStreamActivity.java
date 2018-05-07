package uz.zgora.pl.raspberry.ui.video;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.VideoView;

import butterknife.BindView;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.ui.base.BaseActivity;

import static uz.zgora.pl.raspberry.util.Objects.isNull;

public class VideoStreamActivity extends BaseActivity {
    private static final String VIDEO_STREAM_URL = "http://techslides.com/demos/sample-videos/small.mp4";

    @BindView(R.id.videoStream)
    VideoView videoStreamView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_video;
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isNull(savedInstanceState)) showStream();
    }

    private void showStream() {
        final Uri videoStreamUri = Uri.parse(VIDEO_STREAM_URL);
        videoStreamView.setVideoURI(videoStreamUri);
        videoStreamView.requestFocus();
        videoStreamView.setOnPreparedListener(it -> videoStreamView.start());
    }
}
