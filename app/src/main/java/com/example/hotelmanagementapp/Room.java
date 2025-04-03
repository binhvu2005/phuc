package com.example.hotelmanagementapp;

public class Room {
    private String hotelName;
    private int roomNumber;
    private String roomType;
    private int price;

    public Room(String hotelName, int roomNumber, String roomType, int price) {
        this.hotelName = hotelName;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
    }

    public String getHotelName() { return hotelName; }
    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public int getPrice() { return price; }
}
