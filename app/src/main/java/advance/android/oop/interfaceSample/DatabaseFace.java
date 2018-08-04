package advance.android.oop.interfaceSample;

public interface DatabaseFace {

    void connect(String username, String ip);

    void insert(String query);
}
