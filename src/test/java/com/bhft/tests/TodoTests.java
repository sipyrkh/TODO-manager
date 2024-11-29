package com.bhft.tests;

import com.bhft.api.TodoApi;
import com.bhft.assertions.AssertionTodos;
import com.bhft.data.TodoTestData;
import com.bhft.models.TodoModel;
import com.bhft.utils.TodoUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static com.bhft.data.ApiConstantData.LIMIT_DEFAULT_VALUE;
import static com.bhft.data.ApiConstantData.OFFSET_DEFAULT_VALUE;

public class TodoTests extends TodoTestData {

    @Test(dataProvider = "createTodoDataProvider")
    public void testCreateTodo(TodoModel todoModel, int statusCode, boolean shouldExist) {
        Response response = TodoApi.createTodo(todoModel);
        AssertionTodos.assertStatusCodes(response.statusCode(), statusCode);

        Response responseGetTodos = TodoApi.getTodos(OFFSET_DEFAULT_VALUE, LIMIT_DEFAULT_VALUE);
        List<TodoModel> modelList = TodoUtils.getModels(responseGetTodos);
        AssertionTodos.assertIsTodoExistInList(modelList, todoModel, shouldExist);
    }

    @Test(dependsOnMethods = {"testCreateTodo"}, dataProvider = "getTodoDataProvider")
    public void testGetTodos(int offset, int limit, int sizeList, int statusCode) {
        Response response = TodoApi.getTodos(offset, limit);
        List<TodoModel> modelList = TodoUtils.getModels(response);

        AssertionTodos.assertStatusCodes(response.statusCode(), statusCode);
        AssertionTodos.assertNumberOfTodos(modelList.size(), sizeList);
    }

    @Test(dependsOnMethods = {"testCreateTodo"}, dataProvider = "updateTodoDataProvider")
    public void testUpdateTodo(int updateById, TodoModel todoModel, int statusCode, boolean shouldExist) {
        Response response = TodoApi.updateTodo(updateById, todoModel);
        AssertionTodos.assertStatusCodes(response.statusCode(), statusCode);

        Response responseGetTodos = TodoApi.getTodos(OFFSET_DEFAULT_VALUE, LIMIT_DEFAULT_VALUE);
        List<TodoModel> todoModelList = TodoUtils.getModels(responseGetTodos);
        AssertionTodos.assertIsTodoExistInList(todoModelList, todoModel, shouldExist);
    }


    @Test(dependsOnMethods = {"testUpdateTodo"}, dataProvider = "deleteTodoDataProvider")
    public void testDeleteTodo(TodoModel todoModel, int statusCode, boolean shouldExist, String username, String password) {
        Response response = TodoApi.deleteTodo(todoModel, username, password);
        AssertionTodos.assertStatusCodes(response.getStatusCode(), statusCode);

        Response responseGetTodos = TodoApi.getTodos(OFFSET_DEFAULT_VALUE, LIMIT_DEFAULT_VALUE);
        List<TodoModel> todoModelList = TodoUtils.getModels(responseGetTodos);
        AssertionTodos.assertIsTodoExistInList(todoModelList, todoModel, shouldExist);
    }
}
