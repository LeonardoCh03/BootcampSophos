package Service.appointments;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("api/controller/appointments")
public class index_appointments {
		@Autowired
		private AppointmentsRep T_1;
		@GetMapping
		public ResponseEntity<List<appointments>> getlist(){
			try{
				List<appointments> List_1 =T_1.findAll();
				return ResponseEntity.ok(List_1);
			}catch (Exception e) {
				return  ResponseEntity.status(204).build();
			}
		}
		@GetMapping(value="{id}")
		public ResponseEntity<Optional<appointments>> getbyid(@PathVariable("id") Long id){
				Optional<appointments> search = T_1.findById(id);
				if(search.isPresent()) {
				return ResponseEntity.ok(search);
				}else {
				return  ResponseEntity.status(404).build();
			}
		}
		@PostMapping
		public ResponseEntity<appointments> post(@RequestBody appointments T_2){
			try{
				T_1.save(T_2);
				return ResponseEntity.status(201).build();
			}catch (Exception e) {
				return ResponseEntity.status(404).build();
			}
		}
		@PutMapping
		public ResponseEntity<appointments> put(@RequestBody appointments T_2){
				Optional<appointments> search = T_1.findById(T_2.getId());
				if(search.isPresent()) {
					T_1.save(T_2);
				return  ResponseEntity.status(201).build();
				}else {
				return  ResponseEntity.status(404).build();
			}
		}
		@DeleteMapping(value="{id}")
		public ResponseEntity<appointments> delete(@PathVariable("id") Long id){
			try{
				T_1.deleteById(id);
				return ResponseEntity.status(200).build();
			}catch (Exception e) {
				return ResponseEntity.status(204).build();
			}
		}
		@GetMapping(value="date/{date_1}")
		
		public ResponseEntity<List<appointments>> getByDate(@PathVariable("date_1")String date_1)  {
		  try {
			  
			  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			  java.util.Date date = sdf.parse(date_1);
			  System.out.println(date);
			  List<appointments> list = T_1.findByDate(date);
			  return ResponseEntity.ok(list);
		  	}catch(Exception e) {
		  		return ResponseEntity.status(404).build();
		  	}
		}
		@GetMapping(value="affiliate/{id_search}")
		public ResponseEntity<List<appointments>> getByAffiliate(@PathVariable("id_search") Long id_search) {
		  try {
			  List<appointments> list = T_1.findByAffiliate(id_search);
			  return ResponseEntity.ok(list);
		  	}catch(Exception e) {
		  		return ResponseEntity.status(404).build();
		  	}
		}
		public void setT_1(AppointmentsRep T_1) {
			 this.T_1 = T_1;
		}
}
