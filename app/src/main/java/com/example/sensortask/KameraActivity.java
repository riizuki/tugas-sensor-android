package com.example.sensortask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class KameraActivity extends AppCompatActivity {

    private ImageView imageHolder;
    private final int requestcode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);

        imageHolder = (ImageView) findViewById(R.id.photocapture);
        Button captureimage = (Button) findViewById(R.id.btnAmbil);

        captureimage.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent photo = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photo, requestcode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestcode == requestCode && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }
}
