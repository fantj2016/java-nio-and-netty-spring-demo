package com.reflection.detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fant.J.
 * 2018/2/7 14:37
 */
@MyAnnotation(name="someName",  value = "Hello World")
public class People {
    private Integer id;
    private String name;
    //field 字段
    public String someField = "FantJ";

    private String privateString = "shuai";

    public People(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<String> getStringList(){
        List<String> list = new ArrayList();
        return list;
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }

    public String getPrivateString() {
        return privateString;
    }

    public void setPrivateString(String privateString) {
        this.privateString = privateString;
    }

    public People(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
