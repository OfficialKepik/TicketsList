package net.codejava.tickets;

import java.util.List;
 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public class TicketsRepository extends CrudRepository<Tickets, Long>{
	
	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
	            + " OR c.email LIKE '%' || :keyword || '%'"
	            + " OR c.address LIKE '%' || :keyword || '%'")
	    public List<Tickets> search(@Param("keyword") String keyword);
}
