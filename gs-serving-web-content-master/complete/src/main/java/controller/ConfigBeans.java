package controller;

import dataproviders.DynamoDBDataProvider;
import dataproviders.FlightsDataProvider;
import dataproviders.IDBDataProvider;
import models.Booking;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigBeans {

    @Bean("bookingDataProvider")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IDBDataProvider<Booking> getBookingDataProvider(){
        return new DynamoDBDataProvider<Booking>();
    }

    @Bean("flightsDataProvider")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public FlightsDataProvider getFlightsDataProvider(){
        return new FlightsDataProvider();
    }
}
