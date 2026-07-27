package Amruaz.journalApp.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Amruaz.journalApp.Entity.UserEntry;
import Amruaz.journalApp.Service.UserEntryService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserEntryService userEntryService;
	
	@GetMapping
	public List<UserEntry> getAll()
	{
		return userEntryService.findAll();
	}
	
	
	
	@GetMapping("id/{id}")
	public Optional<UserEntry> getUserEntryById(@PathVariable ObjectId id) {
	    return userEntryService.findById(id);
	}

	@GetMapping("username/{username}")
	public Optional<UserEntry> getUserEntryByUsername(@PathVariable String username) {
	    return Optional.of(userEntryService.findByUserName(username));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserEntryById(@PathVariable ObjectId id)
	{
		userEntryService.deleteById(id);
	}
	
	@DeleteMapping()
	public void deleteUserEntryByUserName(@RequestBody UserEntry myEntry)
	{
		userEntryService.deleteByUserName(myEntry);
	}
	
	@PutMapping()
	public ResponseEntity<?> updateUserEntry( @RequestBody UserEntry myEntry )
	{
		return userEntryService.updateEntry(myEntry);
	}
	
}
