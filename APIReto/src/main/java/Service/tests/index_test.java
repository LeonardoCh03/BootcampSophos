package Service.tests;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/controller/tests")
public class index_test {
	@Autowired
	private TestsRep T_1;
	@GetMapping
	public ResponseEntity<List<tests>> getlist(){
		try{
			List<tests> List_1 =T_1.findAll();
			return ResponseEntity.ok(List_1);
		}catch (Exception e) {
			return  ResponseEntity.status(204).build();
		}
	}
	@GetMapping(value="{id}")
	public ResponseEntity<Optional<tests>> getbyid(@PathVariable("id") Long id){
			Optional<tests> search = T_1.findById(id);
			if(search.isPresent()) {
			return ResponseEntity.ok(search);
			}else {
			return  ResponseEntity.status(404).build();
		}
	}
	@PostMapping
	public ResponseEntity<tests> post(@RequestBody tests T_2){
		try{
			T_1.save(T_2);
			return ResponseEntity.status(201).build();
		}catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}
	@PutMapping
	public ResponseEntity<tests> put(@RequestBody tests T_2){
			Optional<tests> search = T_1.findById(T_2.getId());
			if(search.isPresent()) {
				T_1.save(T_2);
			return  ResponseEntity.status(201).build();
			}else {
			return  ResponseEntity.status(404).build();
		}
	}
	@DeleteMapping(value="{id}")
	public ResponseEntity<tests> delete(@PathVariable("id") Long id){
		try{
			T_1.deleteById(id);
			return ResponseEntity.status(200).build();
		}catch (Exception e) {
			return ResponseEntity.status(204).build();
		}
	}
	 public void setT_1(TestsRep T_1) {
	        this.T_1 = T_1;
	    }

}

