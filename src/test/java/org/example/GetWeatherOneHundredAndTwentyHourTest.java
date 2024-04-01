package org.example;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Weather API")
public class GetWeatherOneHundredAndTwentyHourTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetWeatherOneHundredAndTwentyHourTest (негативный) - поиск погоды за 120 часов ")
    @Description("Негативный тест - проверка получения погоды за 120 часов")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Вызов метода получения погоды за 120 часов")
    @Owner("Крантовская Анна")
    void getOneHundredAndTwentyHour_shouldReturn401(){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"forecasts/v1/hourly/120hour/28580")
                .then()
                .statusCode(401);
    }
}
