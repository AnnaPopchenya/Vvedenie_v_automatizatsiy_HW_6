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
public class GetRegionTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetRegionTest - поиск объекта Region ")
    @Description("Данный тест предназначен для поиска Region")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение объекта Region")
    @Owner("Крантовская Анна")
    void testRegion() {
        List<Location> locationListList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/regions")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Location location = locationListList.get(0); // Получаем первый элемент из списка

        Assertions.assertEquals("Africa", location.getLocalizedName());

    }
}
