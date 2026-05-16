package Amruaz.journalApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import Amruaz.journalApp.Entity.JournalEntry;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, String> {

}
