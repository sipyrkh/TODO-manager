package com.bhft.utils;

import com.bhft.models.TodoModel;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class TodoUtils {

    public static List<TodoModel> getModels(Response response) {
        return !response.body().asPrettyString().startsWith("[") ? new ArrayList<>() :
                response.jsonPath().getList("", TodoModel.class);
    }
}
