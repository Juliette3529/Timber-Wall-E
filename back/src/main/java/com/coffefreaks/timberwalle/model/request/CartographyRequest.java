package com.coffefreaks.timberwalle.model.Request;

import com.coffefreaks.timberwalle.model.Cartography;

public class CartographyRequest extends Cartography {

        public CartographyRequest(int id) {    
            this.id = id;
        }

        public int getId() {
            return id;
        }
        
        public String GetName(){
            Return Name;
        }

        public Double GetMaxWitdh(){
            Return Xmax;
        }

        public Double GetMaxHeight(){
            Return Ymax;
        }

        public void setPosition(Double Xmax, Double Ymax) {
            this.Xmax = Xmax;
            this.Ymax = Ymax;
        }
    }
}
