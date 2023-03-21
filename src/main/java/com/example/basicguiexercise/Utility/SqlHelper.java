package com.example.basicguiexercise.Utility;

public class SqlHelper {

    private String id;
    private String field;
    private String value;

    public SqlHelper(){}

    public SqlHelper(String id, String field, String value) {
        this.id = id;
        this.field = field;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
