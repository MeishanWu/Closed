package com.example.chuan.closed;

import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main{

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static String status(){
        try{
            Log.i("????", "reading");
            String result = getHTML("https://courses.illinois.edu/cisapp/explorer/schedule/2017/fall/CS/374/66445.xml");
            int title = result.indexOf("enrollmentStatus");
            Log.i("????", "read");
            String status = result.substring(title, title + 30);
            return status.substring(status.indexOf(">")+1, status.indexOf("<"));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            return "Unknown";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }


}