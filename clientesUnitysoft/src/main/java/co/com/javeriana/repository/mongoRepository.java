package co.com.javeriana.repository;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.com.javeriana.entity.*;


@Repository
public interface mongoRepository extends MongoRepository<Client, String> {
	
}