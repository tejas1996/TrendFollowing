package com.example.TrendFollowing.testPackage;

import com.example.TrendFollowing.loaders.CsvBarsLoader;
import org.springframework.stereotype.Service;
import org.ta4j.core.TimeSeries;
import org.ta4j.core.indicators.ATRIndicator;
import org.ta4j.core.num.Num;

@Service
public class Atr {


    public static void main(String[] args) {

        TimeSeries series = CsvBarsLoader.loadAppleIncSeries();
        ATRIndicator atrIndicator = new ATRIndicator(series,150);
        Num res = atrIndicator.getValue(150);
        System.out.println(res.getDelegate());

    }

    public long getATR(TimeSeries timeSeries, int days){
        ATRIndicator atrIndicator = new ATRIndicator(timeSeries,days);
        Num result = atrIndicator.getValue(days);
        return (long) result.getDelegate();
    }

}
