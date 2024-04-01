package org.example;


import io.qameta.allure.*;
import org.example.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Weather API")
public class GetWeatherFiveDaysTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetWeatherFiveDaysTest - поиск опогоды за 5 дней ")
    @Description("Данный тест предназначен для получения данных о погоде за 5 дней")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Вызов метода получения погоды за 5 дней")
    @Owner("Крантовская Анна")
    void test5Days() {
        Weather weather = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"forecasts/v1/daily/5day/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Weather.class);

        Assertions.assertEquals(5, weather.getDailyForecasts().size());
        Assertions.assertEquals("rain", weather.getHeadline().getCategory());
    }
}
