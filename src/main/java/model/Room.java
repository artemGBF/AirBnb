package model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private int minimumNights;
    @Expose
    private int numberReviews;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_neighbourhood")
    private Neighbourhood neighbourhood;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_host")
    private Host host;

    public Room() {
    }

    public Room(Long id, String name, double price, int minimumNights, int numberReviews, Neighbourhood neighbourhood, Host host) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.minimumNights = minimumNights;
        this.numberReviews = numberReviews;
        this.neighbourhood = neighbourhood;
        this.host = host;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMinimumNights() {
        return minimumNights;
    }

    public void setMinimumNights(int minimumNights) {
        this.minimumNights = minimumNights;
    }

    public int getNumberReviews() {
        return numberReviews;
    }

    public void setNumberReviews(int numberOfReviews) {
        this.numberReviews = numberOfReviews;
    }

    public Neighbourhood getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(Neighbourhood neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }


    @Override
    public String toString() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);
    }
}
