package dataextractor;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class FetchDataFromAPI {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {

        // issue the Get reques
        String ticker = "TATAMOT";
        FetchDataFromAPI example = new FetchDataFromAPI();
        String url = "https://www.quandl.com/api/v3/datasets/NSE/" + ticker + ".json?&start_date=2012-11-01&end_date=2013-11-30";
        String getResponse = example.doGetRequest(url);
        System.out.println(getResponse);

    }

//      String doPostRequest(String url, String json) throws IOException {
//          RequestBody body = RequestBody.create(JSON, json);
//            Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//            Response response = client.newCall(request).execute();
//            return response.body().string();
//      }

    public static String fetchDataFor(String ticker) throws IOException {

        FetchDataFromAPI example = new FetchDataFromAPI();
        String url = "https://www.quandl.com/api/v3/datasets/NSE/" + ticker + ".json?&start_date=2012-11-01&end_date=2013-11-30";
        String getResponse = example.doGetRequest(url);
        return getResponse;

    }

    // code request code here
    String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}