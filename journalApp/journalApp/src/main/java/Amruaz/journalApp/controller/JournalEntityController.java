package Amruaz.journalApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import Amruaz.journalApp.Service.JournalEntryService;

@RestController
@RequestMapping("/jrnl")
public class JournalEntityController {

	@Autowired
	private JournalEntryService journalEntryService;
	
	@GetMapping
	public List<JournalEntry> getAll()
	{
		return null;
	}
	
	@PostMapping
	public boolean createEntry(@RequestBody JournalEntry myEntry)
	{
		journalEntryService.saveEntry(myEntry);
		return true;	
	}
	
	@GetMapping("/{id}")
	public JournalEntry getJornalEntryById(@PathVariable Long id)
	{
		return null;
	}
	
	@DeleteMapping("/{id}")
	public JournalEntry deleteJornalEntryById(@PathVariable Long id)
	{
		return null;
	}
	
	@PutMapping("/{id}")
	public JournalEntry updateJornalEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry )
	{
		return null;
	}
	
}

