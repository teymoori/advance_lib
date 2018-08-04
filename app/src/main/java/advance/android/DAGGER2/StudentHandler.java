package advance.android.DAGGER2;

import android.content.SharedPreferences;

public class StudentHandler {

    StudentModel std ;
    SharedPreferences shared ;

    public StudentHandler(StudentModel std , SharedPreferences shared) {
        this.std = std;
        this.shared = shared;
    }

    public void saveStduent(){
        //save
    }
}
