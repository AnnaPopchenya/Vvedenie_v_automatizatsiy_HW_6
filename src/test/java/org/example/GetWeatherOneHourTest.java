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
public class GetWeatherOneHourTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetWeatherOneHourTest - поиск погоды за 1 час")
    @Description("Данный тест предназначен для получения данных о погоде за 1 час")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Вызов метода получения погоды за 1 час")
    @Owner("Крантовская Анна")
    void test1Hour() {
        List<Weather> weatherList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "forecasts/v1/hourly/1hour/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Weather.class);

        Weather weather = weatherList.get(0); // Получаем первый элемент из списка

        Assertions.assertEquals("Rain", weather.getPrecipitationType());

    }
}
