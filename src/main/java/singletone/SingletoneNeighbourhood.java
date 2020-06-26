package singletone;

import model.Neighbourhood;

import java.util.ArrayList;
import java.util.List;

public class SingletoneNeighbourhood {
    private static List<Neighbourhood> hoods;

    public static List<Neighbourhood> getInstance() {
        if (hoods != null) {
            return hoods;
        } else {
            hoods = new ArrayList<Neighbourhood>();
            return hoods;
        }
    }

    public static Neighbourhood find(String name) {
        for (int i = 0; i < hoods.size(); i++) {
            if (hoods.get(i).getName().equals(name)) {
                return hoods.get(i);
            }
        }
        return null;
    }
}
