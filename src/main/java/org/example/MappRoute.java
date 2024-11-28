package org.example;

import org.example.Model.Route;

import java.io.IOException;
import java.util.List;

public interface MappRoute {
    List<List<Route>> mapRoutes() throws IOException;
    void printMappedRoutes() throws IOException;
}
