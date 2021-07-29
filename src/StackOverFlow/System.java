package StackOverFlow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class System {
    Map<Integer, Posting> postingMap = new HashMap<>();

    static System system = new System();

    private System(){};

    public static System getInstance() {
        return system;
    }

    public synchronized Integer addPosting(Posting posting) {
        // code that adds posting returns postingId
        return 0;
    }
}
