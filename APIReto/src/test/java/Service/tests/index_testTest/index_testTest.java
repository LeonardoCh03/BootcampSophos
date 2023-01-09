package Service.tests.index_testTest;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import Service.tests.TestsRep;
import Service.tests.index_test;
import Service.tests.tests;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class index_testTest {
	TestsRep mockTestsRep = Mockito.mock(TestsRep.class);
	index_test controller = new index_test();
   
	@Test
	public void testGetList() {
	    List<tests> mockTestList = Arrays.asList(new tests(), new tests());
	    Mockito.when(mockTestsRep.findAll()).thenReturn(mockTestList);
	    controller.setT_1(mockTestsRep);
	    ResponseEntity<List<tests>> response = controller.getlist();
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	    assertThat(response.getBody()).isEqualTo(mockTestList);
	}
	@Test
	public void testGetbyid() {
	    Optional<tests> mockTest = Optional.ofNullable(new tests());
	    Mockito.when(mockTestsRep.findById(1L)).thenReturn(mockTest);
	    controller.setT_1(mockTestsRep);
	    ResponseEntity<Optional<tests>> response = controller.getbyid(1L);
	    assertThat(response.getStatusCode());
	    assertThat(response.getBody());
	}
	@Test
	public void testPost() {
	    tests test = new tests();
	    controller.setT_1(mockTestsRep);
	    ResponseEntity<tests> response = controller.post(test);
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	@Test
	public void testPut() {
	    Optional<tests> mockTest = Optional.of(new tests(1L, "name", "description"));
	    Mockito.when(mockTestsRep.findById(1L)).thenReturn(mockTest);
	    controller.setT_1(mockTestsRep);
	    tests test = new tests(1L, "new name", "new description");
	    ResponseEntity<tests> response = controller.put(test);
	    assertThat(response).isNotNull();
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	@Test
	public void testDelete() {
		controller.setT_1(mockTestsRep);
	    ResponseEntity<tests> response = controller.delete(1L);
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	    Mockito.verify(mockTestsRep).deleteById(1L);
	}

}

