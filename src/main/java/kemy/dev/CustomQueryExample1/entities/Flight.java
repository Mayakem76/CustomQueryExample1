package kemy.dev.CustomQueryExample1.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


@Entity
@Table
public class Flight {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "Description of type of Flight",example = "Intercontinental")
    private String description;
    @ApiModelProperty(value = "Airport of departure",example = "Milan")
    private String departures;
    @ApiModelProperty(value = "Airport of arrival",example = "NewYork")
    private String arrivals;
    @ApiModelProperty(value = "Status of flight ",example = "ONTIME")
    @Enumerated(EnumType.STRING)
    private  Status status;


    public Flight(Long id, String description, String departures, String arrivals, Status status) {
        this.id = id;
        this.description = description;
        this.departures = departures;
        this.arrivals = arrivals;
        this.status = status;
    }
    public Flight(String description, String departures, String arrivals, Status status) {

        this.description = description;
        this.departures = departures;
        this.arrivals = arrivals;
        this.status = status;
    }

    public Flight() {}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartures() {
        return departures;
    }

    public void setDepartures(String departures) {
        this.departures = departures;
    }

    public String getArrivals() {
        return arrivals;
    }

    public void setArrivals(String arrivals) {
        this.arrivals = arrivals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}