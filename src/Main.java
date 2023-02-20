import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Streams  / lambda

        List<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Bogotá");
        cities.add("Ciudad de México");
        cities.add("Lima");

        //índice para recorrer
         /* for (int i  = 0; i < cities.size(); i++){
            System.out.println(cities.get(i));
        }
        Sin índice para recorrer
         For each
            for (String city : cities){
            System.out.println(city);
            }
        */

        //Nueva forma de recorrer arrays en Lambda

        cities.stream().forEach(city -> System.out.println(city));

        //Reference to a method
        cities.stream().forEach(Main::printCity);

        //simple example of parralel - pipeline
        cities.stream().parallel().forEach(System.out::println);

        //filter
        cities.stream().filter(city -> city.startsWith("B")).forEach(System.out::println);

        //Filtros con list y method satic tolist
        List<String> filteredCities = cities.stream().filter(city -> city.startsWith("B"))
                .filter(city -> city.contains("n"))
                .collect(Collectors.toList());

    }
        public static boolean filterCity(String city){
            return city.startsWith("B");
        }
        public static void printCity(String city){
            System.out.println(city);
        }
}