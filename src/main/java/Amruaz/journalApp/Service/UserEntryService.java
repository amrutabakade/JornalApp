package Amruaz.journalApp.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import Amruaz.journalApp.Entity.UserEntry;
import Amruaz.journalApp.Repository.UserEntryRepo;

@Component
public class UserEntryService {
	@Autowired
	private UserEntryRepo userEntryRepo;
	
	private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	public void saveNewUser(UserEntry userEntry)
	{
		userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
		userEntry.setRoles(Arrays.asList("USER"));
		userEntryRepo.save(userEntry);
	}
	
	public void saveUser(UserEntry userEntry)
	{
		userEntryRepo.save(userEntry);
	}

	public List<UserEntry> findAll() {
		// TODO Auto-generated method stub
		return userEntryRepo.findAll();
	}

	public Optional<UserEntry> findById(ObjectId id) {
        return userEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id) {
        userEntryRepo.deleteById(id);
    }

    public UserEntry findByUserName(String username)
    {
    	return userEntryRepo.findByUsername(username);
    }
    
    public ResponseEntity<?> updateEntry(UserEntry newEntry) {
    	Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	UserEntry curUser =  userEntryRepo.findByUsername(username);
        
    	curUser.setUsername(newEntry.getUsername());
    	curUser.setPassword(newEntry.getPassword());
        
        saveNewUser(curUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

	public void deleteByUserName(UserEntry myEntry) {
		// TODO Auto-generated method stub
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	return;
	}
}
