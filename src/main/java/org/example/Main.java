package org.example;


/*#####################################################################################

                       VÄLKOMMEN TILL "SORTING THE LIBRARY"

som beskrivet på hemsidan ska ni nu sortera datat och ta fram hur ni tar er till Ecuador
Ni har helt fria tyglar med hur ni löser det här pusslet, ni väljer hur det ska utformas

    Ni ska ta er från Sverige till Ecuador och antagligen så finns det olika sätt
   Ni kommer behöva visa med koden, dvs det sorterade datat hur rutterna hänger ihop
                    Så en visuallisering kommer behövas.

                 Det finns lite QoL i det här projektet sen innan:
                    Dependencies och en redan uppsatt API-fetch

                        Kan ni hitta alla vägar att ta?
                                HAPPY CODING!!

##################################################################################### */

import org.example.HackathonController.HackathonConfiguration;
import org.example.Model.Route;
import org.example.Service.RouteService;
import org.example.config.ParseConfiguration;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        runApp();

    }
    private static void runApp() throws IOException {
        ParseConfiguration config = new ParseConfiguration();
        RouteService service = new  RouteService(config);
        HackathonConfiguration hackathonConfiguration = new HackathonConfiguration(service);
        hackathonConfiguration.getRoutes();
    }

}