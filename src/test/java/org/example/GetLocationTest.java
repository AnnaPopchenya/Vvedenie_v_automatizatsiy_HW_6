package org.example;


import io.qameta.allure.*;
import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Location API")
public class GetLocationTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест GetLocationTest - поиск объекта Location ")
    @Description("Данный тест предназначен для поиска Location по ключу Minsk")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение объекта Location для Minsk")
    @Owner("Крантовская Анна")
    void getLocationTest() {
        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Minsk")
                .when()
                .get(getBaseUrl()+"locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(6, result.size());

    }
}