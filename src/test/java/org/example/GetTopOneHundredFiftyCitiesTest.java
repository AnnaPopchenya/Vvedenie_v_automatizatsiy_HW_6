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
public class GetTopOneHundredFiftyCitiesTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест GetTopOneHundredFiftyCitiesTest - поиск 150 крупнейших городов ")
    @Description("Данный тест предназначен для поиска 150 крупнейших городов мира")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Получение списка 150 крупнейших городов мира")
    @Owner("Крантовская Анна")
    void testTop150Cities() {
        List<Location> locationList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/topcities/150")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Location location = locationList.get(0);



        Assertions.assertEquals("Dhaka", location.getLocalizedName());

    }
}