package singletone;

import model.Room;

import java.util.ArrayList;
import java.util.List;

public class SingletoneRoom {
    private static List<Room> rooms;

    public static List<Room> getInstance(){
        if(rooms!=null){
            return rooms;
        }
        else{
            rooms = new ArrayList<>();
            return rooms;
        }
    }
}
