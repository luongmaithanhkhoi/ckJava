package com.example.realEstateCk.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaypalConfig {

    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Value("${paypal.mode}")
    private String mode;

//    @Bean
//    public APIContext apiContext() {
//        return new APIContext(clientId, clientSecret, mode);
//    }
    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("mode", mode);

        OAuthTokenCredential tokenCredential = new OAuthTokenCredential(clientId, clientSecret, configMap);
        APIContext context = new APIContext(tokenCredential.getAccessToken());
        context.setConfigurationMap(configMap);

        return context;
    }
}
