package Amruaz.journalApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import Amruaz.journalApp.Entity.JournalEntry;
import Amruaz.journalApp.Entity.UserEntry;
import Amruaz.journalApp.Service.JournalEntryService;
import Amruaz.journalApp.Service.UserEntryService;

@RestController
@RequestMapping("/jrnl")
public class JournalEntityController {

	@Autowired
	private JournalEntryService journalEntryService;
	
	@Autowired
	private UserEntryService userEntryService;
	
	@GetMapping("/{username}")
	public List<JournalEntry> getAllJournalEntriesOfuser(@PathVariable String username)
	{
		UserEntry userEntry = userEntryService.findByUserName(username);
		
		return userEntry.getJournalEntries();
	}
	
	@PostMapping("/{username}")
	public boolean createEntry(@RequestBody JournalEntry myEntry, @PathVariable String username)
	{
		try {
			UserEntry userEntry = userEntryService.findByUserName(username);
			journalEntryService.saveEntry(myEntry, userEntry);				
		}catch(Exception e){
			System.out.println("problem in journal entry post request");
		}
		return true;
	}
	
//	@GetMapping("/{id}")
//	public Optional<JournalEntry> getJornalEntryById(@PathVariable String id) {
//	    return journalEntryService.findById(id);
//	}

	
	@DeleteMapping("/{username}/{id}")
	public void deleteJornalEntryById(@PathVariable String id, @PathVariable String username)
	{
		UserEntry userEntry = userEntryService.findByUserName(username);
		
		userEntry.getJournalEntries().removeIf(x->x.getId().equals(id));
		userEntryService.saveEntry(userEntry);
		journalEntryService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public JournalEntry updateJornalEntryById(@PathVariable String id, @RequestBody JournalEntry myEntry )
	{
		return journalEntryService.updateEntry(id, myEntry);
	}
	
}

