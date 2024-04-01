package org.example;


import io.qameta.allure.*;
import org.example.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Weather API")
public class GetWeatherTwelveHourTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetWeatherTwelveHourTest - поиск погоды за 12 часов")
    @Description("Данный тест предназначен для получения данных о погоде за 12 часов")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Вызов метода получения погоды за 12 часов")
    @Owner("Крантовская Анна")
    void test12Hour() {
        List<Weather> weatherList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "forecasts/v1/hourly/12hour/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Weather.class);

        Weather weather = weatherList.get(0); // Получаем первый элемент из списка

        Assertions.assertEquals("Rain", weather.getPrecipitationType());

    }
}