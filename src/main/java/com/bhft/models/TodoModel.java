package com.bhft.models;

import java.util.Objects;

public class TodoModel {
    private int id;
    private String text;
    private boolean isCompleted;

    public TodoModel() {}

    public TodoModel(int id, String text, boolean isCompleted) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoModel todoModel = (TodoModel) o;
        return id == todoModel.id && isCompleted == todoModel.isCompleted && Objects.equals(text, todoModel.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, isCompleted);
    }
}
