package com.web.analytics;

import com.web.analytics.Entity.LastVisit;
import com.web.analytics.Entity.Visitor;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

@Controller
public class GreetingController {
    @GetMapping("/user")
    public String user(@RequestParam(value = "id") String id, Model model) {
        String url = String.format("http://localhost/matomo/index.php?module=API&method=Live.getVisitorProfile&idSite=1&format=JSON&token_auth=%s&visitorId=%s", getApiKey(), id);
        Gson gson = new Gson();
        Visitor visitor = gson.fromJson(Req(url), Visitor.class);
        model.addAttribute("visitor", visitor);
        return "user";
    }

    @GetMapping
    public String main(Model model) {
        String url = String.format("http://localhost/matomo/index.php?module=API&method=Live.getLastVisitsDetails&idSite=1&period=week&date=today&format=JSON&token_auth=%s", getApiKey());
        Gson gson = new Gson();
        LastVisit[] lastVisits = gson.fromJson(Req(url), LastVisit[].class);
        model.addAttribute("lastVisits", new ArrayList<>(Arrays.asList(lastVisits)));
        return "main";
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

    private String getApiKey(){
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
