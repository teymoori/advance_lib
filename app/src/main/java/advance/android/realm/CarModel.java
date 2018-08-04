package advance.android.realm;

import io.realm.RealmObject;

public class CarModel extends RealmObject {

    String name, model;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CarModel(String name, String model, int price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public CarModel() {
    }
}
