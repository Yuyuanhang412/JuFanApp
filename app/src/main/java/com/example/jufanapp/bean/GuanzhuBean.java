package com.example.jufanapp.bean;

/**
 * Created by w8888 on 2016/10/14.
 */
public class GuanzhuBean {

    private String id;
    private String imag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    public GuanzhuBean() {
    }

    public GuanzhuBean(String id, String imag) {
        this.id = id;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "GuanzhuBean{" +
                "id='" + id + '\'' +
                ", imag='" + imag + '\'' +
                '}';
    }
}
