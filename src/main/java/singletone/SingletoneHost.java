package singletone;

import model.Host;

import java.util.HashSet;
import java.util.Set;

public class SingletoneHost {
    private static Set<Host> hosts;

    public static Set<Host> getInstance(){
        if(hosts !=null){
            return hosts;
        }
        else{
            return new HashSet<Host>();
        }
    }
}
