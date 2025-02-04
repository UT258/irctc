package org.example.entities;



import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainName;
    private String TrainNo;
    private  List<List<Integer>>seats;
    private Map<String, String> stationTimes;

    public Train(String trainName, String trainNumber) {
        this.trainName = trainName;
        this.TrainNo = trainNumber;
    }

    public String getTrainId() {
        return trainId;
    }

    public Train(String trainId, String trainName, String trainNo, List<List<Integer>> seats, Map<String, String> stationTimes) {
        this.trainId = trainId;
        this.trainName = trainName;
        TrainNo = trainNo;
        this.seats = seats;
        this.stationTimes = stationTimes;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNo() {
        return TrainNo;
    }

    public void setTrainNo(String trainNo) {
        TrainNo = trainNo;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public Map<String, String> getStationTimes() {
        return stationTimes;
    }

    public void setStationTimes(Map<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }
}
