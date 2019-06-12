package com.neofytosneocleous.customlayout.properties;

import com.neofytosneocleous.customlayout.models.Property;

import java.util.ArrayList;

public class PropertiesPresenter implements PropertiesContract.Presenter {
    private ArrayList<Property> rentalProperties = new ArrayList<>();
    private PropertiesContract.View view;

    public PropertiesPresenter(PropertiesContract.View view) {
        this.view = view;
    }

    @Override
    public void buildData() {
        //create property elements
        rentalProperties.add(
                new Property(10, "Smith Street", "Sydney", "NSW", "A large 3 bedroom apartment right in the heart of Sydney! A rare find, with 3 bedrooms and a secured car park.", 450.00, "image1", 3, 1, 1, false));

        rentalProperties.add(
                new Property(66, "King Street", "Sydney", "NSW", "A fully furnished studio apartment overlooking the harbour. Minutes from the CBD and next to transport, this is a perfect set-up for city living.", 320.00, "image2", 1, 1, 1, true));

        rentalProperties.add(
                new Property(1, "Liverpool Road", "Liverpool", "NSW", "A standard 3 bedroom house in the suburbs. With room for several cars and right next to shops this is perfect for new families.", 360.00, "image3", 3, 2, 2, false));

        rentalProperties.add(
                new Property(567, "Sunny Street", "Gold Coast", "QLD", "Come and see this amazing studio appartment in the heart of the gold coast, featuring stunning waterfront views.", 360.00, "image4", 1, 1, 1, false));

        view.showData(rentalProperties);


    }
}
