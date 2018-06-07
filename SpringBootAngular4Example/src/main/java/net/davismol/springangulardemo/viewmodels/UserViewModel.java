package net.davismol.springangulardemo.viewmodels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserViewModel {
	
	// si definiscono i due ruoli gestiti dall'applicazione
	public enum Role {
		ROLE_USER, ROLE_ADMIN
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String firstname;
	private String lastname; 
	private String country;
	private int age;

	

}