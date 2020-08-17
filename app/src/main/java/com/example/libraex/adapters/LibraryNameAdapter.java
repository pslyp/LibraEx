package com.example.libraex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.libraex.R;

import java.util.ArrayList;
import java.util.List;

public class LibraryNameAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private int mRes;
    private List<String> mList;

    public LibraryNameAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);

        mContext = context;
        mRes = resource;
        mList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(mRes, null);

        TextView text = view.findViewById(R.id.text_view);
        text.setText("Hello Eiei");

        Button button = view.findViewById(R.id.button);
        button.setText("WoW");

        return view;
    }

}
