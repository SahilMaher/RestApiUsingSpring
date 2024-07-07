package SR.ApiDemoWithMongo.Repository;

import SR.ApiDemoWithMongo.Entity.DataEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public interface DataEntryREpo extends MongoRepository<DataEntry, ObjectId>
{
}
