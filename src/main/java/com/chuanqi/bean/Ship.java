package com.chuanqi.bean;

/**
 * @Description
 * @Author Chauncey
 * @Date 2020/5/12 19:46
 * @Version 1.0
 **/
public class Ship {
    int id;
    String equipmentId;

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", equipmentId='" + equipmentId + '\'' +
                '}';
    }

    public Ship() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Ship(int id, String equipmentId) {
        this.id = id;
        this.equipmentId = equipmentId;
    }
}
