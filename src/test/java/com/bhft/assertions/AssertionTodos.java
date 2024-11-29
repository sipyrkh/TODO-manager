package com.bhft.assertions;

import com.bhft.models.TodoModel;
import org.testng.Assert;

import java.util.List;

public class AssertionTodos {

    public static void assertStatusCodes(int actualStatusCode, int expectedStatusCode) {
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status codes are not equal!");
    }

    public static void assertNumberOfTodos(int actualSize, int expectedSize) {
        Assert.assertEquals(actualSize, expectedSize, "Number of todos are not equal!");
    }

    public static void assertIsTodoExistInList(List<TodoModel> todoModelList, TodoModel todoModel, boolean shouldExistTodo) {
        Assert.assertEquals(todoModelList.contains(todoModel), shouldExistTodo, "Todo should exists in list: " + shouldExistTodo);
        if (shouldExistTodo) {
            Assert.assertTrue(todoModelList.contains(todoModel), "Todo is not contains in list!");
        }
    }
}
