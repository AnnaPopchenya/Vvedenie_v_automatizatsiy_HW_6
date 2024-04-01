package org.example;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Weather API")
public class GetWeatherSeventyTwoHourTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetWeatherSeventyTwoHourTest (негативный) - поиск погоды за 72 часа ")
    @Description("Негативный тест - проверка получения погоды за 72 часа")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Вызов метода получения погоды за 72 часа")
    @Owner("Крантовская Анна")
    void getSeventyTwoHour_shouldReturn401(){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"forecasts/v1/hourly/72hour/28580")
                .then()
                .statusCode(401);
    }
}
