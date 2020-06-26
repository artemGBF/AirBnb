package model;

import com.google.gson.Gson;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "neighbourhood")
public class Neighbourhood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String boroughName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "neighbourhood")
    private transient ArrayList<Room> rooms;

    public Neighbourhood() {
        this.rooms=new ArrayList<>();
    }

    public Neighbourhood(String name, String boroughName) {
        this.name = name;
        this.boroughName = boroughName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBoroughName() {
        return boroughName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoroughName(String boroughName) {
        this.boroughName = boroughName;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
