package servlets;

import com.google.gson.Gson;
import dao.DAO;
import model.Neighbourhood;
import model.Room;
import singletone.SingletoneNeighbourhood;
import singletone.SingletoneRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/aver")
public class Average extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        resp.setCharacterEncoding("utf8");
        req.setCharacterEncoding("utf8");
        String par = req.getParameter("action");
        List rooms = DAO.getAllObjects(Room.class);
        List instance = DAO.getAllObjects(Neighbourhood.class);
        Map<String, ArrayList<Room>> boroughsRooms = new HashMap<>();
        for (int i = 0; i < instance.size(); i++) {
            Neighbourhood neighbourhood = (Neighbourhood)instance.get(i);
            ArrayList<Room> lts = new ArrayList<>();
            for (int j = 0; j < rooms.size(); j++) {
                Room a = (Room)rooms.get(j);
                if (a.getNeighbourhood().getName().equals(neighbourhood.getName())) {
                    lts.add((Room) rooms.get(j));
                }
            }
            if (boroughsRooms.containsKey(neighbourhood.getBoroughName())) {
                ArrayList<Room> roomArrayList = boroughsRooms.get(neighbourhood.getBoroughName());
                roomArrayList.addAll(lts);
                boroughsRooms.put(neighbourhood.getBoroughName(), roomArrayList);
            } else {
                boroughsRooms.put(neighbourhood.getBoroughName(), lts);
            }
        }
        if (par.equals("boroughsRooms")) {
            resp.getWriter().write(new Gson().toJson(boroughsRooms));
        }
        if (par.equals("boroughsAverage")) {
            Map<String, Double> answer = new HashMap<>();
            for (Map.Entry<String, ArrayList<Room>> mapa : boroughsRooms.entrySet()) {
                ArrayList<Room> key = mapa.getValue();
                double cost = 0;
                for (int i = 0; i < key.size(); i++) {
                    cost += key.get(i).getPrice();
                }
                answer.put(mapa.getKey(), cost / key.size());
            }
            resp.getWriter().write(new Gson().toJson(answer));
        }
        //resp.getWriter().write(new Gson().toJson("Херня"));
    }
}
