package com.neofytosneocleous.customlayout.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.neofytosneocleous.customlayout.R;
import com.neofytosneocleous.customlayout.models.Property;

public class PropertyDetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, Property property) {
        Intent intent = new Intent(context, PropertyDetailsActivity.class);
        intent.putExtra("streetNumber", property.getStreetNumber());
        intent.putExtra("streetName", property.getStreetName());
        intent.putExtra("suburb", property.getSuburb());
        intent.putExtra("state", property.getState());
        intent.putExtra("image", property.getImage());
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
    }
}
