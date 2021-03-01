package se.lexicon.GroupProject.hoteljpamvcthymleaf.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Booking;

import java.util.List;

    public interface BookingRepository extends CrudRepository<Booking, String> {

        List<Booking> findAll();
       
        Booking findByBookingId(String bookingId);
}
