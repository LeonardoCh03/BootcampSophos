package Service.appointments.index_appointmentsTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Service.appointments.AppointmentsRep;
import Service.appointments.appointments;
import Service.appointments.index_appointments;

@SpringBootTest
public class index_appointmentsTest {
	AppointmentsRep mockTestsRep = Mockito.mock(AppointmentsRep.class);
	index_appointments controller = new index_appointments();
	LocalDate date = LocalDate.parse("14-12-12", DateTimeFormatter.ofPattern("dd-MM-yy"));
	String timestamp = "2070-01-10 10:30:00.00";
	Timestamp instant = Timestamp.valueOf(timestamp);
	@Test
	public void testGetList() {
	    List<appointments> mockTestList = Arrays.asList(new appointments(), new appointments());
	    Mockito.when(mockTestsRep.findAll()).thenReturn(mockTestList);
	    controller.setT_1(mockTestsRep);
	    ResponseEntity<List<appointments>> response = controller.getlist();
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	    assertThat(response.getBody()).isEqualTo(mockTestList);
	}
	@Test
	public void testGetbyid() {
	    Optional<appointments> mockTest = Optional.ofNullable(new appointments());
	    Mockito.when(mockTestsRep.findById(1L)).thenReturn(mockTest);
	    controller.setT_1(mockTestsRep);
	    ResponseEntity<Optional<appointments>> response = controller.getbyid(1L);
	    assertThat(response.getStatusCode());
	    assertThat(response.getBody());
	}
	@Test
	public void testPost() {
	    appointments test = new appointments();
	    controller.setT_1(mockTestsRep);
	    ResponseEntity<appointments> response = controller.post(test);
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	@Test
	public void testPut() {
	    Optional<appointments> mockTest = Optional.of(new appointments(1L, date , instant ,1L,1L));
	    Mockito.when(mockTestsRep.findById(1L)).thenReturn(mockTest);
	    controller.setT_1(mockTestsRep);
	    appointments test = new appointments(1L, date , instant ,1L,1L);
	    ResponseEntity<appointments> response = controller.put(test);
	    assertThat(response).isNotNull();
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	@Test
	public void testDelete() {
		controller.setT_1(mockTestsRep);
	    ResponseEntity<appointments> response = controller.delete(1L);
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	    Mockito.verify(mockTestsRep).deleteById(1L);
	}
	@Test
	public void testGetByDate() throws ParseException {
		String dateString = "01-01-22";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		java.util.Date date_1 = sdf.parse(dateString);
	    List<appointments> mockAppointmentsList = Arrays.asList(new appointments(), new appointments());
	    AppointmentsRep mockAppointmentsRep = Mockito.mock(AppointmentsRep.class);
	    Mockito.when(mockAppointmentsRep.findByDate(date_1)).thenReturn(mockAppointmentsList);
	    index_appointments controller = new index_appointments();
	    controller.setT_1(mockAppointmentsRep);
	    ResponseEntity<List<appointments>> response = controller.getByDate(dateString);
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	    assertThat(response.getBody()).isEqualTo(mockAppointmentsList);
	}
	@Test
	public void testGetByAffiliate() {
	    // Set up test data
	    Long id = 123L;
	    List<appointments> mockAppointmentsList = Arrays.asList(new appointments(), new appointments());

	    // Set up mock object
	    AppointmentsRep mockAppointmentsRep = Mockito.mock(AppointmentsRep.class);
	    Mockito.when(mockAppointmentsRep.findByAffiliate(id)).thenReturn(mockAppointmentsList);

	    // Set up controller and call method under test
	    index_appointments controller = new index_appointments();
	    controller.setT_1(mockAppointmentsRep);
	    ResponseEntity<List<appointments>> response = controller.getByAffiliate(id);

	    // Verify results
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	    assertThat(response.getBody()).isEqualTo(mockAppointmentsList);
	}
}
