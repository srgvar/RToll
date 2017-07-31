package jdev.server;

/**
 * Created by srgva on 18.07.2017.
 */

import jdev.dto.PointDTO;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class ServerTest{
    @Test
    public void testServer() {
        System.out.println("Server-core tests...");
        String restRequest =
        "http://localhost:8080/test?point=[\'lat\':123,\'lon\':40]";
        URL url = null;
        try {
            url = new URL(restRequest);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String response = "None";
        try {
            response = IOUtils.toString(url,"UTF8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("returned point = " + response);


    }
}
