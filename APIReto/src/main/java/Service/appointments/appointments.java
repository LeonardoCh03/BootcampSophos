package Service.appointments;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="appointments")
public class appointments {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.NATURAL, pattern = "dd-MM-yy")
	private LocalDate date;
	@Column(name="hora")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.NATURAL, pattern = "HH:mm")
	private Timestamp hour;
	@Column(name="id_test")
	private Long id_test;
	@Column(name="id_affiliate")
	private Long id_affiliate;
	public appointments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public appointments(LocalDate date, Timestamp hour, Long id_test, Long id_affiliate) {
		super();
		this.date = date;
		this.hour = hour;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}
	public appointments(Long id, LocalDate date, Timestamp hour, Long id_test, Long id_affiliate) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Timestamp getHour() {
		return hour;
	}
	public void setHour(Timestamp hour) {
		this.hour = hour;
	}
	public Long getId_test() {
		return id_test;
	}
	public void setId_test(Long id_test) {
		this.id_test = id_test;
	}
	public Long getId_affiliate() {
		return id_affiliate;
	}
	public void setId_affiliate(Long id_affiliate) {
		this.id_affiliate = id_affiliate;
	}
}
