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
public class GetTopOneHundredCitiesTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест GetTopOneHundredCitiesTest - поиск 100 крупнейших городов ")
    @Description("Данный тест предназначен для поиска 100 крупнейших городов мира")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Получение списка 100 крупнейших городов мира")
    @Owner("Крантовская Анна")
    void testTop100Cities() {
        List<Location> locationList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/topcities/100")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Location location = locationList.get(0);
        Location location1 = locationList.get(4);

        Assertions.assertEquals("Dhaka", location.getLocalizedName());
        Assertions.assertEquals("Colombia", location1.getCountry().getLocalizedName());
    }
}
