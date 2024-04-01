package org.example;


import io.qameta.allure.*;
import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Location API")
public class GetSearchLocationTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetSearchLocationTest - поиск местоположения Location ")
    @Description("Данный тест предназначен для поиска местоположении по ключу местоположения Minsk")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Получение объекта Location для Minsk")
    @Owner("Крантовская Анна")
    void testSearchLocation() {
        Location location = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Location.class);

        Assertions.assertEquals("Minsk", location.getLocalizedName());

    }
}
