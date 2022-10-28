package lesson.lesson_10_27.StatusCode;

import org.apache.hc.core5.http.HttpConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class StatusCodeTest {



    @Test
    public void StatusCodeTest() throws IOException {
        HttpConnection c = (HttpConnection) new URL("https://the-internet.herokuapp.com/status_codes/200").openConnection();
//        c.c();
//        int statusCode = c.getRes`();
//        System.out.println(statusCode);
//        Assert.assertEquals(statusCode, 200);

    }

}
