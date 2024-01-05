package com.orbitelco.inventory.data;

import com.orbitelco.inventory.data.entity.Room;
import com.orbitelco.inventory.data.entity.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

  private final RoomRepository roomRepository;

  public CLRunner(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<Room> rooms = this.roomRepository.findAll();
    Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
    System.out.println(room);
    rooms.forEach(System.out::println);
  }
}
