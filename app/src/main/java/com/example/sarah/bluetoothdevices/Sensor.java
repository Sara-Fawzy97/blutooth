package com.example.sarah.bluetoothdevices;

public class Sensor {
    int id,state;
    String name,date;

    public Sensor(){}

    public Sensor(int id, int state, String name, String date) {
        this.id = id;
        this.state = state;
        this.name = name;
        this.date = date;
    }

    public Sensor(int state){
        this.state=state;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
