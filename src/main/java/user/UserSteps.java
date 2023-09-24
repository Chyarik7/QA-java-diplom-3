package user;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserSteps {
    public static String baseURL = "https://stellarburgers.nomoreparties.site/";
    public static String userPath = "/api/auth/user";
    public static String userLoginPath = "/api/auth/login";
    public static String userRegisterPath = "api/auth/register";
    @Step("Создание пользователя")
    public static Response createNewUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(userRegisterPath);
    }
    @Step("Логин пользователя")
    public static Response loginUser(UserLogin userLogin) {
        return given()
                .header("Content-type", "application/json")
                .body(userLogin)
                .when()
                .post(userLoginPath);
    }
    @Step("Удаление пользователя")
    public static Response deleteUser(String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .when()
                .delete(userPath);
    }
}