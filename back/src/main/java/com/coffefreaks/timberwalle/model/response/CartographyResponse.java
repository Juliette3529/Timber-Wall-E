package com.coffefreaks.timberwalle.model.Response;

import com.coffefreaks.timberwalle.model.Cartography;

public class CartographyResponse extends Cartography {

        public CartographyResponse(Double Xmax, Double Ymax) {
        this.setXmax(Xmax);
        this.setYmax(Ymax);
    }
}
