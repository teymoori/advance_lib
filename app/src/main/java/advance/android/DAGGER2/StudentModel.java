package advance.android.DAGGER2;

import android.content.Context;

public class StudentModel {

    String name, family, city;

    LocationModel location ;

    public StudentModel(LocationModel location , Context mContext) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
