package com.example.libraex.models;

import androidx.annotation.NonNull;

public class ButtonFeature {

    private final String text;
    private final Class<?> activity;

    public ButtonFeature(@NonNull String text, @NonNull Class<?> activity) {
        this.text = text;
        this.activity = activity;
    }

    public String getText() {
        return text;
    }

    public Class<?> getActivity() {
        return activity;
    }

}
