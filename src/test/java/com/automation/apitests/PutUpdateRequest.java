package com.automation.apitests;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Properties;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.OutputStreamWriter;

public class PutUpdateRequest {

    URL url;
    HttpURLConnection httpCon;
    OutputStreamWriter out;

    @Test
    public void TestAPIPut() throws IOException {
        httpCon = null;
        url = null;
        try {
            URL url = new URL("http://fltspc.itu.dk/widget/515318fe17450f312b00153d/");
            //random = new Random();
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Content-Type", "application/json");
            httpCon.setRequestProperty("Accept", "application/json");
            String payload = payLoad.getPutData();
            out = new OutputStreamWriter(httpCon.getOutputStream());
            out.write(payload);
            out.close();
            System.err.println(httpCon.getResponseCode());
            httpCon.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}



