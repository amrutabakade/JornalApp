package Amruaz.journalApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Amruaz.journalApp.Entity.JournalEntry;
import Amruaz.journalApp.Entity.UserEntry;
import Amruaz.journalApp.Repository.JournalEntryRepo;

@Component
public class JournalEntryService {

	@Autowired
	private JournalEntryRepo journalEntryRepo;
	
	@Autowired
	private UserEntryService userEntryService;
	
	public void saveEntry(JournalEntry journalEntry, UserEntry userEntry)
	{
		JournalEntry saved = journalEntryRepo.save(journalEntry);
		userEntry.getJournalEntries().add(saved);
		userEntryService.saveEntry(userEntry);
	}

	public List<JournalEntry> findAll() {
		// TODO Auto-generated method stub
		return journalEntryRepo.findAll();
	}

	public Optional<JournalEntry> findById(String id) {
        return journalEntryRepo.findById(id);
    }

    public void deleteById(String id) {
        journalEntryRepo.deleteById(id);
    }

    public JournalEntry updateEntry(String id, JournalEntry newEntry) {
        return journalEntryRepo.findById(id)
            .map(existing -> {
                existing.setTitle(newEntry.getTitle());
                existing.setContent(newEntry.getContent());
                existing.setDate(newEntry.getDate());
                return journalEntryRepo.save(existing);
            })
            .orElse(null);
    }
}
