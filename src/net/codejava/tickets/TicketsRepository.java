package net.codejava.tickets;

import java.util.List;
 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TicketsRepository extends CrudRepository<Tickets, Long> {
	
	@Query(value = "SELECT c FROM Tickets c WHERE c.name LIKE '%' || :keyword || '%'"
	            + " OR c.email LIKE '%' || :keyword || '%'"
	            + " OR c.address LIKE '%' || :keyword || '%'")
	    public List<Tickets> search(@Param("keyword") String keyword);
}
