package com.neofytosneocleous.customlayout.details;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neofytosneocleous.customlayout.R;
import com.neofytosneocleous.customlayout.models.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyDetailsAdapter extends ArrayAdapter<Property> {

    private Context context;
    private List<Property> properties;

    public PropertyDetailsAdapter(Context context, int resource, ArrayList<Property> objects) {
        super(context, resource, objects);

        this.context = context;
        this.properties = objects;
    }
    public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {
        Property property = properties.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        android.view.View view;

        view = inflater.inflate(R.layout.detail_layout, null);


        TextView description = view.findViewById(R.id.description);
        TextView address = view.findViewById(R.id.address);
        TextView bedroom = view.findViewById(R.id.bedroom);
        TextView bathroom = view.findViewById(R.id.bathroom);
        TextView carspot = view.findViewById(R.id.carspot);
        TextView price = view.findViewById(R.id.price);
        ImageView image = view.findViewById(R.id.image);

        String completeAddress = property.getStreetNumber() + " " + property.getStreetName() + ", " + property.getSuburb() + ", " + property.getState();
        address.setText(completeAddress);

        int descriptionLength = property.getDescription().length();
        if (descriptionLength >= 100) {
            String descriptionTrim = property.getDescription().substring(0, 100) + "...";
            description.setText(descriptionTrim);
        } else {
            description.setText(property.getDescription());
        }

        String numberOfBedsText = context.getString(R.string.bed_with_value, property.getBedrooms());

        price.setText("$" + String.valueOf(property.getPrice()));
        bedroom.setText("Bed: " + String.valueOf(property.getBedrooms()));
        bathroom.setText(numberOfBedsText);
        carspot.setText("Car: " + String.valueOf(property.getCarspots()));

        int imageID = context.getResources().getIdentifier(property.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);

        return view;

    }

    }
