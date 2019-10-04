package hello;

import dataproviders.DevicesDataProvider;
import dataproviders.MongoDBDataProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigBeans {
    @Bean
    public DevicesDataProvider getDevicesDataProvider()
    {
        return new DevicesDataProvider(new MongoDBDataProvider("inventory"));
    }
}
