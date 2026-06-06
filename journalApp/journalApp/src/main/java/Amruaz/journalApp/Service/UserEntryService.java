package Amruaz.journalApp.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import Amruaz.journalApp.Entity.UserEntry;
import Amruaz.journalApp.Repository.UserEntryRepo;

@Component
public class UserEntryService {
	@Autowired
	private UserEntryRepo userEntryRepo;
	
	public void saveEntry(UserEntry userEntry)
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
    
    public ResponseEntity<?> updateEntry(String username, UserEntry newEntry) {
        UserEntry curUser =  userEntryRepo.findByUsername(username);
        
        if(curUser != null)
        {
        	curUser.setUsername(newEntry.getUsername());
        	curUser.setPassword(newEntry.getPassword());
        }
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
