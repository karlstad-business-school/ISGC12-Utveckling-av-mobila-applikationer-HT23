package com.example.hantera_data_v4;

import android.media.Image;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.widget.ListViewCompat;

public class ListItem {
    private ImageView image;
    private TextView text;
    private Button button;


    public ListItem(ImageView image, TextView text, Button button){
        this.image = image;
        this.text = text;
        this.button = button;
    }

    public Button getButton() {
        return button;
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getText() {
        return text;
    }
}
