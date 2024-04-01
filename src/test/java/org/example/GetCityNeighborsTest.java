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
public class GetCityNeighborsTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetCityNeighborsTest - поиск соседних городов объекта Minsk ")
    @Description("Данный тест предназначен для поиска соседних городов по ключу Minsk")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.MINOR)
    @Story("Поиск соседних городов для объекта Minsk")
    @Owner("Крантовская Анна")
    void testCityNeighbors() {
        List<Location> locationListList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/cities/neighbors/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Location location = locationListList.get(0); // Получаем первый элемент из списка

        Assertions.assertEquals("Fanipal", location.getLocalizedName());

    }
}