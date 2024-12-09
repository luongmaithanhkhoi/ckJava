package com.example.realEstateCk.service;

import com.example.realEstateCk.model.City;
import com.example.realEstateCk.model.District;
import com.example.realEstateCk.model.Ward;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String LOCATION_API_URL = "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json";

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<City> getCities() {
        try {
            // Set headers to explicitly accept JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Fetch the response as String first, then manually deserialize
            ResponseEntity<String> response = restTemplate.exchange(
                    LOCATION_API_URL,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            String responseBody = response.getBody();

            if (responseBody == null) {
                throw new RuntimeException("No data returned from the API");
            }

            // Deserialize manually using ObjectMapper
            City[] cities = objectMapper.readValue(responseBody, City[].class);

            if (cities == null) {
                throw new RuntimeException("Failed to parse response JSON");
            }

            return List.of(cities);

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch cities data from API", e);
        }
    }

    public String getCityName(String cityId) {
        return getCities().stream()
                .filter(city -> city.getId().equals(cityId))
                .map(City::getName)
                .findFirst()
                .orElse("City not found");
    }
    public String getDistrictName(String cityId, String districtId) {
        return getCities().stream()
                .filter(city -> city.getId().equals(cityId))
                .flatMap(city -> city.getDistricts().stream())
                .filter(district -> district.getId().equals(districtId))
                .map(District::getName)
                .findFirst()
                .orElse(null);
    }

    public String getWardName(String cityId, String districtId, String wardId) {
        return getCities().stream()
                .filter(city -> city.getId().equals(cityId))
                .flatMap(city -> city.getDistricts().stream())
                .filter(district -> district.getId().equals(districtId))
                .flatMap(district -> district.getWards().stream())
                .filter(ward -> ward.getId().equals(wardId))
                .map(Ward::getName)
                .findFirst()
                .orElse(null);
    }
}