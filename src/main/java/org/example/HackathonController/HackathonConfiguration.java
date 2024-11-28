package org.example.HackathonController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.Model.Route;
import org.example.Service.RouteService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackathonConfiguration {

    private final RouteService routeService;


    public HackathonConfiguration(RouteService routeService) {
        this.routeService = routeService;
    }

    public void getRoutes() throws IOException {
        routeService.mapRoutes();
        routeService.printMappedRoutes();

    }
}
