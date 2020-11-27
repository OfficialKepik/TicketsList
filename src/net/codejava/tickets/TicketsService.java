package net.codejava.tickets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TicketsService {
    @Autowired TicketsRepository repo;
     
    public void save(Tickets tickets) {
        repo.save(tickets);
    }
     
    public List<Tickets> listAll() {
        return (List<Tickets>) repo.findAll();
    }
     
    public Tickets get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
    public List<Tickets> search(String keyword) {
        return repo.search(keyword);
    }
     
}
