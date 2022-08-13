package kemy.dev.CustomQueryExample1.entities;

import javax.persistence.*;

/*Exercise - Spring Boot - Custom Queries 1
write a Spring Boot application with the necessary dependencies that:
has an entity Flight with the following columns:
a primary key
a string description
a string fromAirport
a string toAirport
an enum status
the possible values are ONTIME, DELAYED and CANCELLED
has a dedicated repository
has a FlightController:
mapped on flights
for the provisioning of 50 flights where:
all the string values are randomly generated (using random.ints())
the default status is ON_TIME
for retrieving all the flights in the db
test the 2 endpoints with Postman
 */
@Entity
@Table
public class Fligth {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String fromAirport;
    private String toAirport;
    @Enumerated(EnumType.STRING)
    private  Status status;


    public Fligth(Long id, String description, String fromAirport, String toAirport, Status status) {
        this.id = id;
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }

    public Fligth() {}

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

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}