package hotel;

import java.time.LocalDate;
import java.util.*;

public class BookingManager {

	private Room[] rooms;

	public BookingManager() {
		this.rooms = initializeRooms();
	}

	public Set<Integer> getAllRooms() {
		Set<Integer> allRooms = new HashSet<Integer>();
		Iterable<Room> roomIterator = Arrays.asList(rooms);
		for (Room room : roomIterator) {
			allRooms.add(room.getRoomNumber());
		}
		return allRooms;
	}

	public boolean isRoomAvailable(Integer roomNumber, LocalDate date) {
		//implement this method

		return false;
	}

	public void addBooking(BookingDetail bookingDetail) {
		//implement this method
		LocalDate date = bookingDetail.getDate();
		Integer roomNb = bookingDetail.getRoomNumber();
		if (isRoomAvailable(roomNb, date)) {
			for (Room currentRoom : rooms) {
				if (Objects.equals(currentRoom.getRoomNumber(), roomNb)) {
					List<BookingDetail> list = new ArrayList<BookingDetail>();
					list.add(bookingDetail);
					currentRoom.setBookings(list);
				}
			}
		}
	}

	public Set<Integer> getAvailableRooms(LocalDate date) {
		//implement this method
		Set<Integer> availableRooms = new HashSet<Integer>();

		for (Room currentRoom : rooms) {
			if (isRoomAvailable(currentRoom.getRoomNumber(), date)) {
				availableRooms.add(currentRoom.getRoomNumber());
			}
		}
		return availableRooms;
	}

	private static Room[] initializeRooms() {
		Room[] rooms = new Room[4];
		rooms[0] = new Room(101);
		rooms[1] = new Room(102);
		rooms[2] = new Room(201);
		rooms[3] = new Room(203);
		return rooms;
	}
}
