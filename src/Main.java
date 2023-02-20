import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        //Download webs
        List<String> links  = new ArrayList<>();
        links.add("https://www.bbc.com/");
        links.add("https://www.bbc.com/news/world-europe-64702548");
        links.add("https://www.bbc.com/news/world-europe-64637091");
        links.add("https://www.bbc.com/news/world-latin-america-64701062");
        links.add("https://www.bbc.com/sport/football/64708314");
        links.add("https://www.bbc.com/sport/football/64704536");
        links.add("https://www.bbc.com/sport/live/cricket/64045176");
        links.add("https://www.bbc.com/news/live/world-europe-64702090");

        /* Long timeStart = System.nanoTime();
        Esto para ver cuanto tiempo tarda en cargar y ejecutar un proceso o función. Se debe omitier 9 decimales para ver el tiempo en segundos
        links.stream().forEach(link -> getWebContent(link)); Demora 2708304600
        Long timeEnd = System.nanoTime();
        System.out.println("Difference: " + (timeEnd -timeStart));

        timeStart = System.nanoTime();
        links.stream().parallel().forEach(link -> getWebContent(link)); Demora 1430529700
        timeEnd = System.nanoTime();
        System.out.println("Difference: " + (timeEnd -timeStart));

        */

        links.stream().parallel().forEach(link -> getWebContent(link));
        String link  = "https://www.bbc.com/";
        String result = getWebContent(link);

    }

    public synchronized static String getWebContent(String link) {
            System.out.println("INIT");
            System.out.println(link);
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();

            InputStream input = conn.getInputStream();

            Stream <String> lines = new BufferedReader(new InputStreamReader(input))
                    .lines();

            System.out.println("END");

            return lines.collect(Collectors.joining());

        } catch (IOException e){
            System.out.print(e.getMessage());
        }
        return "";
    }
}