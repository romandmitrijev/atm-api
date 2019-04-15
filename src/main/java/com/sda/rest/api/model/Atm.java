package com.sda.rest.api.model;

import javax.persistence.*;

@Entity
@Table(name = "Atm")
public class Atm {

    @Id
    @GeneratedValue
    @Column(name = "atm_id")
    private Long id;

    @Column(name = "distance")
    private Long distance;

    @Column(name = "atm_type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
