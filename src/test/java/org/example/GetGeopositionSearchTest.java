package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com ")
@Feature("Тестирование API Location API")
public class GetGeopositionSearchTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetGeopositionSearchTest (негативный) - поиск геопозиции ")
    @Description("Негативный тест - проверка поиска геопозиции")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение геопозиции объекта")
    @Owner("Крантовская Анна")
    void getGeopositionSearch_shouldReturn400(){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"locations/v1/cities/geoposition/search")
                .then()
                .statusCode(400);
    }
}
