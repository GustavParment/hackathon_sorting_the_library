package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.Model.Route;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.io.IOException;


public class ParseConfiguration {
    public List<Route> getAllRoutes () throws IOException {
    String content = Files.readString(Paths.get("library_data.json"));

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    CollectionType listType = objectMapper
            .getTypeFactory()
            .constructCollectionType(List.class, Route.class);

    return objectMapper.readValue(content,listType);

}
}
