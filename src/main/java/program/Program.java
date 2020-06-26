package program;

import dao.DAO;
import model.Host;
import model.Neighbourhood;
import model.Room;

import java.io.*;
import java.nio.charset.Charset;

public class Program {
    public static void main(String[] args) {
        /*try {
            File f1 = new File( "C:\\Tomcat 8.5\\bin\\data\\rooms.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f1), Charset.forName("UTF-8")));
            br.readLine();
            while (br.ready()) {
                Host a;
                String[] split = br.readLine().split(";");
                 a = new Host(Long.parseLong(split[2]),split[3]);
                if (DAO.getObjectById(Long.parseLong(split[2]), Host.class)==null) {
                    DAO.addObject(a);
                    Host host = (Host)DAO.getObjectById(Long.parseLong(split[2]), Host.class);
                    System.out.println(host);
                }
                Neighbourhood neighbourhood = (Neighbourhood) DAO.getObjectByParam("name", split[4], Neighbourhood.class);
                System.out.println(neighbourhood);
                Room r = new Room(Long.parseLong(split[0]), split[1],
                        Double.parseDouble(split[6].trim().replace("$", "").replace(",", ".").replace(" ", "")),
                        Integer.parseInt(split[7]), Integer.parseInt(split[9]), neighbourhood,a);
                System.out.println(r);
                if(DAO.getObjectByParams(new String[]{"name", "price", "minimumNights", "numberReviews"}, new Object[]{split[1],Double.parseDouble(split[6].trim().
                        replace("$", "").replace(",", ".").replace(" ", "")), Integer.parseInt(split[7]), Integer.parseInt(split[9])}, Room.class)==null) {
                    DAO.addObject(r);
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
