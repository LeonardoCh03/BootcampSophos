package Service.affiliates.index_affiliatesTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Service.affiliates.AffiliatesRep;
import Service.affiliates.affiliates;
import Service.affiliates.index_affiliates;

@SpringBootTest
public class index_affiliatesTest {
	AffiliatesRep mockAffiliatesRep = Mockito.mock(AffiliatesRep.class);
	index_affiliates controller = new index_affiliates();
		@Test
		public void testGetList() {
		    List<affiliates> mockAffiliatesList = Arrays.asList(new affiliates(), new affiliates());
		    Mockito.when(mockAffiliatesRep.findAll()).thenReturn(mockAffiliatesList);
		    controller.setT_1(mockAffiliatesRep);
		    ResponseEntity<List<affiliates>> response = controller.getlist();
		    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		    assertThat(response.getBody()).isEqualTo(mockAffiliatesList);
		}
		@Test
		public void testGetbyid() {
		    Optional<affiliates> mockTest = Optional.of( new affiliates());
		    Mockito.when(mockAffiliatesRep.findById(1L)).thenReturn(mockTest);
		    controller.setT_1(mockAffiliatesRep);
		    ResponseEntity<Optional<affiliates>> response = controller.getbyid(1L);
		    assertThat(response.getStatusCode());
		    assertThat(response.getBody());
		}
		@Test
		public void testPost() {
		    affiliates affi = new affiliates(1L, null, 0, null);
		    controller.setT_1(mockAffiliatesRep);
		    ResponseEntity<affiliates> response = controller.post(affi);
		    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		}
		@Test
		public void testPut() {
		    Optional<affiliates> mockTest = Optional.of(new affiliates(1L, "name",10, "email"));
		    Mockito.when(mockAffiliatesRep.findById(1L)).thenReturn(mockTest);
		    controller.setT_1(mockAffiliatesRep);
		    affiliates affi = new affiliates(1L, "new name",10, "new email");
		    ResponseEntity<affiliates> response = controller.put(affi);
		    assertThat(response).isNotNull();
		    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		}
		@Test
		public void testDelete() {
			controller.setT_1(mockAffiliatesRep);
		    ResponseEntity<affiliates> response = controller.delete(1L);
		    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		    Mockito.verify(mockAffiliatesRep).deleteById(1L);
		}

}
