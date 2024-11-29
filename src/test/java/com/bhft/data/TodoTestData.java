package com.bhft.data;

import com.bhft.models.TodoModel;
import org.testng.annotations.DataProvider;

import static com.bhft.data.ApiConstantData.*;

public class TodoTestData {

    @DataProvider(name = "createTodoDataProvider")
    public Object[][] todoDataProvider() {
        return new Object[][] {
                { new TodoModel(1, "Text one", false), STATUS_CODE_201, true },
                { new TodoModel(2, "LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG" +
                        "LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG LONG TEXT", true), STATUS_CODE_201, true },
                { new TodoModel(3, "", false), STATUS_CODE_201, true },
                { new TodoModel(-4, "Negative ID", true), STATUS_CODE_400, false },
                { new TodoModel(1, "Existing ID", true), STATUS_CODE_400, false }
        };
    }

    @DataProvider(name = "getTodoDataProvider")
    public Object[][] getTodoDataProvider() {
        return new Object[][] {
                { 0, 10, 3, STATUS_CODE_200 },
                { 1, 10, 2, STATUS_CODE_200 },
                { 0, 0, 0, STATUS_CODE_200 },
                { -1, 10, 0, STATUS_CODE_400 },
                { 0, -10, 0, STATUS_CODE_400 }
        };
    }

    @DataProvider(name = "updateTodoDataProvider")
    public Object[][] updateTodoDataProvider() {
        return new Object[][] {
                { 1, new TodoModel(1, "Updated text", false), STATUS_CODE_200, true },
                { 1, new TodoModel(4, "New ID", true), STATUS_CODE_200, true },
                { 2, new TodoModel(3, "Duplicated ID", false), STATUS_CODE_200, true },
                { 3, new TodoModel(5, "Same IDs", false), STATUS_CODE_200, true },
                { 4, new TodoModel(-1, "Negative ID", true), STATUS_CODE_401, false }
        };
    }

    @DataProvider(name = "deleteTodoDataProvider")
    public Object[][] deleteTodoDataProvider() {
        return new Object[][] {
                { new TodoModel(3, "", false), STATUS_CODE_204, false, USERNAME, PASSWORD },
                { new TodoModel(4, "Same IDs", false), STATUS_CODE_204, false, USERNAME, PASSWORD },
                { new TodoModel(2, "Non-existing ID", true), STATUS_CODE_404, false, USERNAME, PASSWORD },
                { new TodoModel(5, "Same IDs", false), STATUS_CODE_401, true, USERNAME, INCORRECT_PASSWORD },
                { new TodoModel(5, "Same IDs", false), STATUS_CODE_204, false, USERNAME, PASSWORD }
        };
    }
}
