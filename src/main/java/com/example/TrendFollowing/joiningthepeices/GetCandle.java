package com.example.TrendFollowing.joiningthepeices;

import com.example.TrendFollowing.CandlestickChart;
import dataextractor.FetchDataFromAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ta4j.core.TimeSeries;

import java.io.IOException;

@RestController
public class GetCandle {

    FetchDataFromAPI fetchDataFromAPI = new FetchDataFromAPI();
    @Autowired
    CandlestickChart candlestickChart;

    @GetMapping(value = "/ticker/{ticker}")
    public String getData(@PathVariable String ticker) {
        String data = null;
        System.out.println("got request for this ticker =" + ticker);
        try {
            data = fetchDataFromAPI.fetchDataFor(ticker);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;


    }


}
