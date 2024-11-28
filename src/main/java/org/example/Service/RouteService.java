package org.example.Service;

import org.example.MappRoute;
import org.example.Model.Route;
import org.example.config.ParseConfiguration;

import java.io.IOException;
import java.time.temporal.ChronoField;
import java.util.*;

public record RouteService(ParseConfiguration config) implements MappRoute {
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    @Override
    public List<List<Route>> mapRoutes() throws IOException {
        List<Route> firstAlternative = new ArrayList<>();
        List<Route> secondAlternative = new ArrayList<>();
        List<Route> thirdAlternative = new ArrayList<>();

        config.getAllRoutes().forEach(route -> {
            switch (route.getId()) {
                case "669e2f3be1a63c1a80ebe010":
                case "669e2f3be1a63c1a80ebe00b":
                case "669e2f3be1a63c1a80ebe009":
                case "669e2f3be1a63c1a80ebe00a":
                    firstAlternative.add(route);
                    break;
                case "669e2f3be1a63c1a80ebe018":
                case "669e2f3be1a63c1a80ebe00c":
                    secondAlternative.add(route);
                    break;
                case "669e2f3be1a63c1a80ebe00d":
                case "669e2f3be1a63c1a80ebe00e":
                case "669e2f3be1a63c1a80ebe00f":
                case "669e2f3be1a63c1a80ebe013":
                case "669e2f3be1a63c1a80ebe011":
                case "669e2f3be1a63c1a80ebe012":
                    thirdAlternative.add(route);
                    break;
            }
        });

        Collections.reverse(firstAlternative);
        Collections.reverse(secondAlternative);



        return List.of(firstAlternative, secondAlternative, thirdAlternative);
    }

    @Override
    public void printMappedRoutes() throws IOException {
        List<List<Route>> allRoutes = mapRoutes();

        System.out.println(RED + "Första alternativet:" + RESET);
        printRouteDetails(allRoutes.get(0));

        System.out.println(RED + "Andra alternativet:" + RESET);
        printRouteDetails(allRoutes.get(1));

        System.out.println(RED + "Tredje alternativet:" + RESET);
        printRouteDetails(allRoutes.get(2));
    }

    private void printRouteDetails(List<Route> routes) {
        double totalCostForRoutes = 0;
        long totalTimeForRoutes = 0;

        for (Route route : routes) {
            System.out.println("Rutt ID: " + route.getId());
            System.out.println("Från: " + route.getTravelFrom() + " Till: " + route.getTravelTo());
            System.out.println("Reseform: " + route.getTravelType());
            System.out.println("Avgång: " + route.getDepartureDateTime());
            System.out.println("Ankomst: " + route.getDepartureDateTime()
                    .plusHours(route.getTravelTime().getLong(ChronoField.HOUR_OF_DAY))
                    .plusMinutes(route.getTravelTime().getLong(ChronoField.MINUTE_OF_HOUR)));
            System.out.println("Pris: " + route.getPrice() + " SEK");
            System.out.println("Fordon: " + route.getVehicleNumber());
            System.out.println("Försening: " + (route.isDelayed() ? "Ja" : "Nej") + ", Förseningstid: " + route.getHoursDelayed());
            System.out.println("Information: " + route.getInformation());
            System.out.println("-----------");

            totalCostForRoutes += route.getPrice();
            totalTimeForRoutes += route.getTravelTime().toSecondOfDay() / 60;
        }
        long hoursForRoute = totalTimeForRoutes / 60;
        long minutesForRoute = totalTimeForRoutes % 60;

        System.out.println("Total kostnad för detta alternativ: " + totalCostForRoutes + " SEK");
        System.out.println("Total restid för detta alternativ: " + hoursForRoute + " timmar och " + minutesForRoute + " minuter");
    }
}
