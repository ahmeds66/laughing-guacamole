package com.ares.mpjfx.classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Voll {
    private SimpleIntegerProperty code;
    private SimpleStringProperty vol;
    private Date date;
    private SimpleStringProperty heureDep;
    private SimpleStringProperty heureArr;
    private SimpleStringProperty status;

    public Voll(){

    }

    public Voll(String vol, Date date, String heureDep, String heureArr, String status) {
        this.vol = new SimpleStringProperty(vol);
        this.date = new Date();
        this.heureDep = new SimpleStringProperty(heureDep);
        this.heureArr = new SimpleStringProperty(heureArr);
        this.status = new SimpleStringProperty(status);
    }


    public int getCode() {
        return code.get();
    }

    public SimpleIntegerProperty codeProperty() {
        return code;
    }

    public void setCode(int code) {
        this.code.set(code);
    }

    public String getVol() {
        return vol.get();
    }

    public SimpleStringProperty volProperty() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol.set(vol);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeureDep() {
        return heureDep.get();
    }

    public SimpleStringProperty heureDepProperty() {
        return heureDep;
    }

    public void setHeureDep(String heureDep) {
        this.heureDep.set(heureDep);
    }

    public String getHeureArr() {
        return heureArr.get();
    }

    public SimpleStringProperty heureArrProperty() {
        return heureArr;
    }

    public void setHeureArr(String heureArr) {
        this.heureArr.set(heureArr);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
