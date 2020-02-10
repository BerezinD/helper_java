package entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private Integer id;

    @Column(name = "car_model")
    private String model;
}
