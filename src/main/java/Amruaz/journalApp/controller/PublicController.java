package Amruaz.journalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Amruaz.journalApp.Entity.UserEntry;
import Amruaz.journalApp.Service.UserEntryService;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	private UserEntryService userEntryService;
	
	@PostMapping
	public boolean createEntry(@RequestBody UserEntry myEntry)
	{
		userEntryService.saveNewUser(myEntry);
		return true;	
	}
}
