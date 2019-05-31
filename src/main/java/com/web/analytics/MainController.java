package com.web.analytics;

import com.web.analytics.Entity.User;
import com.web.analytics.Entity.Visit;
import com.web.analytics.Entity.Visitor;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
public class MainController {
    private List<String> conducts = new ArrayList<String>() {
        {
            add("Поверхностный читатель");
            add("Активный читатель");
            add("Избирательный читатель");
            add("Досканальный читатель");
        }
    };

    @GetMapping("/user")
    public String user(@RequestParam(value = "id") String id, Model model) {
        Visitor visitor = getUserById(id);
        defineBehavior(visitor);
        model.addAttribute("visitor", visitor);
        return "user";
    }

    @GetMapping("/")
    public String main(Model model) {
        String url = String.format("http://localhost/matomo/index.php?module=API&method=UserId.getUsers&idSite=1&period=month&date=2019-05-30&format=JSON&token_auth=%s", getApiKey());
        Gson gson = new Gson();
        User[] visitors = gson.fromJson(Req(url), User[].class);
        for (User visitor : visitors) {
            visitor.setTotal_visit_length(timeConversion(visitor.getSum_visit_length()));
        }
        model.addAttribute("visitors", new ArrayList<>(Arrays.asList(visitors)));
        return "main";
    }

    private Visitor getUserById(String id) {
        String url = String.format("http://localhost/matomo/index.php?module=API&method=Live.getVisitorProfile&idSite=1&format=JSON&language=ru&token_auth=%s&visitorId=%s", getApiKey(), id);
        Gson gson = new Gson();
        return gson.fromJson(Req(url), Visitor.class);
    }

    private void defineBehavior(Visitor visitor) {
        float kBehavior = (float) visitor.getTotalVisitDuration() / visitor.getTotalVisits() / visitor.getTotalPageViews();
        if (visitor.getTotalVisits() < 1) {
            visitor.setConduct("Гость");
        } else if (kBehavior < 1) {
            visitor.setConduct("Поверхностный читатель");
        } else if (kBehavior > 1 && kBehavior < 2) {
            visitor.setConduct("Активный читатель");
        } else if (kBehavior > 2 && kBehavior < 3) {
            visitor.setConduct("Избирательный читатель");
        } else if (kBehavior > 3) {
            visitor.setConduct("Досканальный читатель");
        }
    }

    private String timeConversion(long totalSeconds) {

        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;

        long seconds = totalSeconds % SECONDS_IN_A_MINUTE;
        long totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        long minutes = totalMinutes % MINUTES_IN_AN_HOUR;
        long hours = totalMinutes / MINUTES_IN_AN_HOUR;

        return hours + " ч " + minutes + " мин " + seconds + " сек";
    }

    private String Req(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
            httpURLConnection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private String getApiKey() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            return property.getProperty("api_key");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
