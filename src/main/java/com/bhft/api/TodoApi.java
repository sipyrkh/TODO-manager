package com.bhft.api;

import com.bhft.models.TodoModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.bhft.data.ApiConstantData.*;

public class TodoApi {

    public static Response getTodos(int offset, int limit) {
        return RestAssured.given()
                .queryParam(OFFSET, offset)
                .queryParam(LIMIT, limit)
                .when()
                .get(TODOS_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public static Response createTodo(TodoModel todoModel) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(todoModel)
                .when()
                .post(TODOS_ENDPOINT)
                .then().extract().response();
    }

    public static Response updateTodo(int id, TodoModel todoModel) {
         return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(todoModel)
                .when()
                .put(TODOS_ENDPOINT + "/" + id)
                .then()
                 .extract()
                 .response();
    }

    public static Response deleteTodo(TodoModel todoModel, String username, String password) {
        return RestAssured.given()
                .auth()
                .preemptive()
                .basic(username, password)
                .contentType(ContentType.JSON)
                .when()
                .delete(TODOS_ENDPOINT + "/" + todoModel.getId())
                .then()
                .extract()
                .response();
    }
}
