package com.pojo;

public class Clockin {
    private int id;
    private int totalLectureNumber;
    private int currentClockinNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalLectureNumber() {
        return totalLectureNumber;
    }

    public void setTotalLectureNumber(int totalLectureNumber) {
        this.totalLectureNumber = totalLectureNumber;
    }

    public int getCurrentClockinNumber() {
        return currentClockinNumber;
    }

    public void setCurrentClockinNumber(int currentClockinNumber) {
        this.currentClockinNumber = currentClockinNumber;
    }
}
