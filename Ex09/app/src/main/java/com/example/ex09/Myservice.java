package com.example.ex09;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class Myservice extends Service {
    MediaPlayer media;

    @Override
    public IBinder onBind(Intent intent) {
        return null;  // Không cần ném UnsupportedOperationException
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Khởi tạo MediaPlayer
        media = MediaPlayer.create(Myservice.this, R.raw.media);
        if (media != null) {
            media.setLooping(true);  // Lặp lại nếu cần
        } else {
            Log.e("Myservice", "Lỗi khi khởi tạo MediaPlayer");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Kiểm tra và phát nhạc
        if (media != null) {
            if (media.isPlaying()) {
                media.pause();  // Nếu đang phát thì tạm dừng
            } else {
                media.start();  // Nếu không phát thì bắt đầu
            }
        } else {
            // Nếu media bị null, tạo lại và bắt đầu phát
            media = MediaPlayer.create(Myservice.this, R.raw.media);
            if (media != null) {
                media.setLooping(true);
                media.start();
            } else {
                Log.e("Myservice", "Không thể tạo lại MediaPlayer");
            }
        }
        return START_STICKY;  // Dịch vụ tự khởi động lại nếu bị dừng
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Giải phóng tài nguyên MediaPlayer
        if (media != null) {
            media.stop();
            media.release();
            media = null;
        }
    }
}
