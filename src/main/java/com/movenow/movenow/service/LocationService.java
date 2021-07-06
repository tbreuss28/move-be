package com.movenow.movenow.service;

import org.springframework.stereotype.Service;

@Service
public class LocationService
{
    public Double CalculateDistance(Double latitude1, Double longitude1, Double latitude2, Double longitude2){
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(latitude1 - latitude2);
        double lonDistance = Math.toRadians(longitude1 - longitude2);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude2)) * Math.cos(Math.toRadians(latitude1))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
}