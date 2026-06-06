package Amruaz.journalApp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import Amruaz.journalApp.Entity.UserEntry;

public interface UserEntryRepo extends MongoRepository<UserEntry, ObjectId> {

	UserEntry findByUsername(String username);
}
