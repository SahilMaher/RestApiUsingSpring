package SR.ApiDemoWithMongo.Service;


import SR.ApiDemoWithMongo.Entity.DataEntry;
import SR.ApiDemoWithMongo.Repository.DataEntryREpo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class DataEntryService
{
    @Autowired
    private DataEntryREpo  dataEntryRepo;
    @Autowired
    private DataEntryREpo dataEntryREpo;

    public void saveData(DataEntry dnt)
    {
        dataEntryRepo.save(dnt);
    }
    public List<DataEntry> getAll()
    {
        return  dataEntryRepo.findAll();
    }
    public Optional<DataEntry> findOne(ObjectId id)
    {
        return Optional.ofNullable(dataEntryRepo.findById(id).orElse(null));
    }
    public  void deleteData(ObjectId myId)
    {
        dataEntryRepo.deleteById(myId);
    }

}
