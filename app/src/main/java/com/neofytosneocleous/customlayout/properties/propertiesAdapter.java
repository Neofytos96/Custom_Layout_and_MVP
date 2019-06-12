package com.neofytosneocleous.customlayout.properties;

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

//custom ArrayAdapter
class propertiesAdapter extends ArrayAdapter<Property> {

    private Context context;
    private List<Property> properties;

    //constructor, call on creation
    public propertiesAdapter(Context context, int resource, ArrayList<Property> objects) {
        super(context, resource, objects);

        this.context = context;
        this.properties = objects;
    }

    //called when rendering the list
    public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {

        //get the property we are displaying
        Property property = properties.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            View view = inflater.inflate(R.layout.property_layout_alt, null);
        //conditionally inflate either standard or special template
        android.view.View view;
        if (property.getFeatured() == true) {
            view = inflater.inflate(R.layout.property_layout_alt, null);
        } else {
            view = inflater.inflate(R.layout.property_layout, null);
        }

        TextView description = view.findViewById(R.id.description);
        TextView address = view.findViewById(R.id.address);
        TextView bedroom = view.findViewById(R.id.bedroom);
        TextView bathroom = view.findViewById(R.id.bathroom);
        TextView carspot = view.findViewById(R.id.carspot);
        TextView price = view.findViewById(R.id.price);
        ImageView image = view.findViewById(R.id.image);

        //set address and description
        String completeAddress = property.getStreetNumber() + " " + property.getStreetName() + ", " + property.getSuburb() + ", " + property.getState();
        address.setText(completeAddress);

        //display trimmed excerpt for description
        int descriptionLength = property.getDescription().length();
        if (descriptionLength >= 100) {
            String descriptionTrim = property.getDescription().substring(0, 100) + "...";
            description.setText(descriptionTrim);
        } else {
            description.setText(property.getDescription());
        }

        //set price and rental attributes
        String numberOfBedsText = context.getString(R.string.bed_with_value, property.getBedrooms());

        price.setText("$" + String.valueOf(property.getPrice()));
        bedroom.setText("Bed: " + String.valueOf(property.getBedrooms()));
        bathroom.setText(numberOfBedsText);
        carspot.setText("Car: " + String.valueOf(property.getCarspots()));

        //get the image associated with this property
        int imageID = context.getResources().getIdentifier(property.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);

        return view;
    }
}
