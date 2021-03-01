package se.lexicon.GroupProject.hoteljpamvcthymleaf.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, String> {
    List<Room> findAll();
    Optional<Room> findById(String id);
    List<Room> findByRoomType(String type);
    Room findByRoomId(String roomId);
}
