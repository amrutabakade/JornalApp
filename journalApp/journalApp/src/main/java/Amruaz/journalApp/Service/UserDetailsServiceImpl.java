package Amruaz.journalApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import Amruaz.journalApp.Entity.UserEntry;
import Amruaz.journalApp.Repository.UserEntryRepo;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{ 

	@Autowired
	private UserEntryRepo userEntryRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		UserEntry userEntry = userEntryRepo.findByUsername(username);
		
		if(userEntry != null)
		{
			return  org.springframework.security.core.userdetails.User.builder()
			.username(userEntry.getUsername())
			.password(userEntry.getPassword())
			.roles(userEntry.getRoles().toArray(new String[0]))
			.build();
		}
		throw new UsernameNotFoundException("user not found : " + username);
	}
}
