package Service.appointments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentsRep extends JpaRepository<appointments,Long> {
	 @Query(value = "SELECT * FROM appointments WHERE fecha = :date order by id_affiliate", nativeQuery = true)
	  List<appointments> findByDate(@Param("date") java.util.Date date);
	  @Query(value = "SELECT * FROM appointments WHERE id_affiliate = :id_search", nativeQuery = true)
	  List<appointments> findByAffiliate(@Param("id_search") Long id_search);
}
