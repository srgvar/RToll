package jdev.tracker;

import jdev.dto.PointDTO;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by srgva on 17.07.2017.
 */

public class TrackerTest {
    String fileName = ".\\resource\\tracks\\10158.kml";
    @Test
    public void testTracker() throws IOException {

        System.out.println("TrackerTest....");

        PointDTO point = new PointDTO();
        point.setTime(System.currentTimeMillis());
        point.setLat(50L);
        point.setLon(150L);
        point.setAutoId("z456xcv");
        point.setSpeed(130);
        point.setBearing(35.35);
        /*ArrayList<String> s = new ArrayList<String>();

        s.add("123"); s.add("456");s.add("789");

        for(String s1 : s){
            System.out.println(s1);
        }*/
        System.out.println(point.toString());
        System.out.println(URLEncoder.encode(point.toJson(),"UTF8"));

        String restRequest = "http://localhost:8080/tracker?point="+ URLEncoder.encode(point.toJson(),"UTF8");
        //System.out.println(restRequest);
        URL url = new URL(restRequest);

        String response;
        response = IOUtils.toString(url,"UTF8");

        System.out.println(response);
    }
}
