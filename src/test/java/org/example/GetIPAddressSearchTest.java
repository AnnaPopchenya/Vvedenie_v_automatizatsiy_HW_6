package org.example;


import io.qameta.allure.*;
import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Location API")
public class GetIPAddressSearchTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetIPAddressSearchTest - поиск IP-адреса ")
    @Description("Данный тест предназначен для поиска IPAddress")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Получение IP-адреса")
    @Owner("Крантовская Анна")
    void testIPAddressSearch() {
        Location location = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/cities/ipaddress")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Location.class);

        Assertions.assertEquals("Brest", location.getLocalizedName());

    }
}

