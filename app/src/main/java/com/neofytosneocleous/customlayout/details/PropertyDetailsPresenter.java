package com.neofytosneocleous.customlayout.details;

import com.neofytosneocleous.customlayout.models.Property;
import com.neofytosneocleous.customlayout.properties.PropertiesContract;

import java.util.ArrayList;

public class PropertyDetailsPresenter  implements PropertyDetailsContract.Presenter{

    private ArrayList<Property> rentalPropertiesDetails = new ArrayList<>();
    private PropertiesContract.View view;

    public PropertyDetailsPresenter(PropertiesContract.View view) {
        this.view = view;
    }

    @Override
    public void buildData() {

    }
}
