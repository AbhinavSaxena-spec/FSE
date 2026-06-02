// Exercise 36: HTTP Client API (Java 11+) – Fetch GitHub user data
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

public class Ex36_HttpClient {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/octocat"))
                .header("Accept", "application/vnd.github+json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("\nResponse Body (raw JSON):");
        System.out.println(response.body());

        // Basic manual JSON field extraction (no external lib needed)
        String body = response.body();
        printField(body, "login");
        printField(body, "name");
        printField(body, "public_repos");
        printField(body, "followers");
    }

    static void printField(String json, String key) {
        // Naive key extractor — replace with Jackson/Gson for production
        String search = "\"" + key + "\":";
        int idx = json.indexOf(search);
        if (idx == -1) return;
        int start = idx + search.length();
        int end   = json.indexOf(",", start);
        if (end == -1) end = json.indexOf("}", start);
        System.out.println(key + " = " + json.substring(start, end).trim().replace("\"", ""));
    }
}
