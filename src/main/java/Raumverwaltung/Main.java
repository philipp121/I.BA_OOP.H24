package Raumverwaltung;

public class Main {
    public static void main(String[] args) {
        RoomManagement roomManagement = new RoomManagement();
        roomManagement.addRoom(new Room (200, 29));
        roomManagement.getRoom(88);
    }
}
