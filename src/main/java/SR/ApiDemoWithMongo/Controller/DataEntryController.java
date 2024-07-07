package SR.ApiDemoWithMongo.Controller;

import SR.ApiDemoWithMongo.Entity.DataEntry;
import SR.ApiDemoWithMongo.Repository.DataEntryREpo;
import SR.ApiDemoWithMongo.Service.DataEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/Data")
public class DataEntryController
{
    @Autowired
    private DataEntryService dataEntryService;
    @PostMapping
    public void addData(@RequestBody DataEntry dnt)
    {
        dataEntryService.saveData(dnt);


           }
           @GetMapping
    public List<DataEntry> getAll()
           {
               return dataEntryService.getAll();
           }
           @GetMapping("id/{myId}")
    public DataEntry getOne(@PathVariable ObjectId myId)
           {
               return dataEntryService.findOne(myId).orElse(null);
           }
           @DeleteMapping("id/{myId}")
           public Boolean deleteData(@PathVariable ObjectId myId)
           {
               dataEntryService.deleteData(myId);
               return true;
           }
           @PutMapping("/id/{myId}")
           public void updateData(@PathVariable ObjectId myId,@RequestBody DataEntry newData)
           {
               DataEntry old=dataEntryService.findOne(myId).orElse(null);
               if(old!=null) {
                   old.setName(newData.getName() == null && newData.getName().equals(" ") ? old.getName() : newData.getName());
                   old.setPass(newData.getPass() == null && newData.getPass().equals(" ") ? old.getPass() : newData.getPass());
               }
               dataEntryService.saveData(old);


           }
}
