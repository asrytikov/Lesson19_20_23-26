package p6;

import p2.Car;

public class SCar extends Car {

    private String owner;

    public SCar(String model, int price, String owner) {
        super(model, price);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
