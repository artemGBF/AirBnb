package model;

import com.google.gson.Gson;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "host")
public class Host {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "host")
    private transient ArrayList<Room> rooms;

    public Host() {
        this.rooms=new ArrayList<>();
    }

    public Host(Long id, String name) {
        this.id=id;
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
