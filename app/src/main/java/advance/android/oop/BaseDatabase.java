package advance.android.oop;

import advance.android.utils.Gen;

abstract class BaseDatabase {

    abstract void connect(String ip, String username, String password, String dbName);

    abstract void insert(String query);

    abstract void delete(String query);

    abstract void update(String query);

    abstract String select(String query);

    abstract void create(String query);

    static public void setOwnerName(String ownerName) {
        Gen.log("owner name is " + ownerName);
    }

    abstract public void setname();

}
