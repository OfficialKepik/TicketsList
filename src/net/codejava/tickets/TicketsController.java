package net.codejava.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketsController {

	@Autowired
    private TicketsService ticketsService;
	
	@RequestMapping("/")
	public ModelAndView home() {
	    List<Tickets> listTickets = ticketsService.listAll();
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("listTickets", listTickets);
	    return mav;
	}
	
	@RequestMapping("/new")
	public String newTicketsForm(Map<String, Object> model) {
		Tickets tickets = new Tickets();
	    model.put("tickets", tickets);
	    return "new_ticket";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTickets(@ModelAttribute("tickets") Tickets tickets) {
		ticketsService.save(tickets);
	    return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editTicketForm(@RequestParam long id) {
	    ModelAndView mav = new ModelAndView("edit_ticket");
	    Tickets tickets = ticketsService.get(id);
	    mav.addObject("tickets", tickets);
	 
	    return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteTicketsForm(@RequestParam long id) {
		ticketsService.delete(id);
	    return "redirect:/";       
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Tickets> result = ticketsService.search(keyword);
	    ModelAndView mav = new ModelAndView("search");
	    mav.addObject("result", result);
	 
	    return mav;    
	}
}
