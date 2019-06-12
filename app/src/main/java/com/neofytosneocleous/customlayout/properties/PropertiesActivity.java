package com.neofytosneocleous.customlayout.properties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neofytosneocleous.customlayout.details.PropertyDetailsActivity;
import com.neofytosneocleous.customlayout.models.Property;
import com.neofytosneocleous.customlayout.R;

import java.util.ArrayList;

public class PropertiesActivity extends AppCompatActivity implements PropertiesContract.View {
    private PropertiesContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PropertiesPresenter(this);
        presenter.buildData();
    }

    @Override
    public void showData(final ArrayList<Property> items) {
        //create our new array adapter
        ArrayAdapter<Property> adapter =
                new propertiesAdapter(this, 0, items);

        //Find list view and bind it with the custom adapter
        ListView listView = findViewById(R.id.customListView);
        listView.setAdapter(adapter);

        //set the listener to the list view
        AdapterView.OnItemClickListener onItemClickListener = getOnItemClickListener(items);
        listView.setOnItemClickListener(onItemClickListener);

    }

    private AdapterView.OnItemClickListener getOnItemClickListener(final ArrayList<Property> items) {
        //add event listener so we can handle clicks
        return new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Property property = items.get(position);
                PropertyDetailsActivity.startActivity(view.getContext(), property);
            }
        };
    }
}