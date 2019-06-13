package com.neofytosneocleous.customlayout.details;

import com.neofytosneocleous.customlayout.models.Property;

import java.util.ArrayList;

public interface PropertyDetailsContract {

    interface View {
        void showData (ArrayList<Property> propertyDetails);
    }

    interface Presenter{
        void buildData();
    }
}

