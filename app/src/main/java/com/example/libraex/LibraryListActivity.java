package com.example.libraex;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.libraex.models.ButtonFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryListActivity extends AppCompatActivity {

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_list);

        initInstance();
        startProcess();
    }

    private void initInstance() {
        container = findViewById(R.id.name_list_container);
    }

    private void startProcess() {
        List<ButtonFeature> buttonList = createButtonList();
        for (int index=0; index<buttonList.size(); index++) {

            ButtonFeature buttonFeature = buttonList.get(index);
            String text = buttonFeature.getText();
            final Class<?> activityClass = buttonFeature.getActivity();

            Button button = new Button(getApplicationContext());
            button.setText(text);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LibraryListActivity.this, activityClass));
                }
            });

            container.addView(button);
        }
    }

    private List<ButtonFeature> createButtonList() {
        List<ButtonFeature> buttonList = new ArrayList<>();
        buttonList.add(new ButtonFeature("Generate QRCode", GenQRCodeActivity.class));
        buttonList.add(new ButtonFeature("Honey Toast", GenQRCodeActivity.class));

        return buttonList;
    }

}