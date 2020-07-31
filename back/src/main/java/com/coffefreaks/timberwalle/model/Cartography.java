package com.coffefreaks.timberwalle.model;

public class Cartography {
        
        private Double Xmax;
        private Double Ymax;
        private String Name;


        public Cartography() {
    }

    public Double getXmax() {
        return Xmax;
    }

    public void setXmax(Double Xmax) {
        this.Xmax = Xmax;
    }

    public Double getYmax() {
        return Ymax;
    }

    public void setYmax(Double Ymax) {
        this.Ymax = Ymax;
    }

    @Override
    public String toString() {
        return "Cartography{" +
                "Xmax=" + Xmax +
                ", Ymax=" + Ymax +
                '}';
    }

}
