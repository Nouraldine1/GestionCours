package entites;

import java.util.HashMap;
import java.util.Map;

public enum Filliere {
    IAGE, MAE;

    private static final Map<String, Filliere> lookup = new HashMap<>();

    static {
        for (Filliere filliere : Filliere.values()) {
            lookup.put(filliere.name(), filliere);
        }
    }

    public static Filliere get(String name) {
        return lookup.get(name);
    }
}
