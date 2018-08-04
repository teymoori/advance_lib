package advance.android.oop.interfaceSample;

public class DatabaseWork {

    DatabaseFace db ;

    public DatabaseWork(DatabaseFace db) {
        this.db = db;

        db.connect("ali" , "12312313");
    }
}
