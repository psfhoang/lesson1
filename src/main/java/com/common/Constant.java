package com.common;

public enum Constant {
    DRIVER("com.mysql.cj.jdbc.Driver"),URL_DATABASE("jdbc:mysql://localhost:3306/book"),
    USERNAME("root"),PASSWORD("123456");

    private String value;
    Constant(String value){
        this.value=value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
