package Amruaz.journalApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Amruaz.journalApp.Entity.JournalEntry;
import Amruaz.journalApp.Repository.JournalEntryRepo;

@Component
public class JournalEntryService {

	@Autowired
	private JournalEntryRepo journalEntryRepo;
	
	public void saveEntry(JournalEntry journalEntry)
	{
		journalEntryRepo.save(journalEntry);
	}
}
