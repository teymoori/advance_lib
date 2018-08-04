package advance.android.recyclerPro.entities;

import io.realm.RealmObject;

public class FoodModel extends RealmObject {
    private String foodName, foodPrice, foodType, foodImage ;


    public FoodModel() {
    }


    private FoodModel(Builder builder) {
        setFoodName(builder.foodName);
        setFoodPrice(builder.foodPrice);
        setFoodType(builder.foodType);
        setFoodImage(builder.foodImage);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public String getFoodName() {
        return foodName;
    }

    public FoodModel setFoodName(String foodName) {
        this.foodName = foodName;
        return this ;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodType() {
        return foodType;
    }

    public FoodModel setFoodType(String foodType) {
        this.foodType = foodType;
        return this;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    @Override
    public String toString() {
        return "FoodModel{" +
                "foodName='" + foodName + '\'' +
                ", foodPrice='" + foodPrice + '\'' +
                ", foodType='" + foodType + '\'' +
                ", foodImage='" + foodImage + '\'' +
                '}';
    }


    public static final class Builder {
        private String foodName;
        private String foodPrice;
        private String foodType;
        private String foodImage;

        private Builder() {
        }

        public Builder foodName(String val) {
            foodName = val;
            return this;
        }

        public Builder foodPrice(String val) {
            foodPrice = val;
            return this;
        }

        public Builder foodType(String val) {
            foodType = val;
            return this;
        }

        public Builder foodImage(String val) {
            foodImage = val;
            return this;
        }

        public FoodModel build() {
            return new FoodModel(this);
        }
    }


}
