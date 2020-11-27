package net.codejava.tickets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tickets {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    private String name;
	    private String email;
	    private String address;
	 
	    protected Tickets() {
	    }
	 
	    protected Tickets(String name, String email, String address) {
	        this.name = name;
	        this.email = email;
	        this.address = address;
	    }
	    
}
