package com.neofytosneocleous.customlayout.properties;

import com.neofytosneocleous.customlayout.models.Property;

import java.util.ArrayList;

public interface PropertiesContract {
    interface View {
        void showData(ArrayList<Property> properties);
    }
    interface Presenter {
        void buildData();
    }
}
