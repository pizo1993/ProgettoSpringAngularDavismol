package net.davismol.springangulardemo.viewmodels;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@Entity
public class UserViewModel {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private String firstname;
	private String lastname; 
	private String country;
	private int age;
	

}