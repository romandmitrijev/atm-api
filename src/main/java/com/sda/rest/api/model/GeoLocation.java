package com.sda.rest.api.model;

import javax.persistence.*;

@Entity
@Table(name="geolocation")
public class GeoLocation {

    @Id
    @GeneratedValue
    @Column(name= "geo_id")
    private Long geoId;

    @Column(name= "lat")
    private double lat;

    @Column(name= "lng")
    private double lng;

    public Long getGeoId() {
        return geoId;
    }

    public void setGeoId(Long geoId) {
        this.geoId = geoId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
