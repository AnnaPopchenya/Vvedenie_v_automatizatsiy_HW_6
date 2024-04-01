package org.example;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Weather API")
public class GetWeatherFifteenDaysTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест GetWeatherFifteenDaysTest (негативный) - поиск погоды за 15 дней ")
    @Description("Негативный тест - проверка получения погоды за 15 дней")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Вызов метода получения погоды за 15 дней")
    @Owner("Крантовская Анна")
    void getFifteenDays_shouldReturn401(){
        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 28580)
                .when()
                .get(getBaseUrl()+"forecasts/{version}/daily/15day/{location}")
                .then()
                .statusCode(401);
    }
}