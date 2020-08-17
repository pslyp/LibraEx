package com.example.libraex;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;

public class GenQRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_qr_code);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edit_text);
                String text = editText.getText().toString().trim();

                if (!text.equals("")) {
                    QRCodeWriter qrCodeWriter = new QRCodeWriter();
                    try {
                        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
                        Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565);

                        for (int x = 0; x < 200; x++) {
                            for (int y = 0; y < 200; y++) {
                                bitmap.setPixel(x, y, (bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE));
                            }
                        }

                        ImageView imageView = findViewById(R.id.image_view);
                        imageView.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}