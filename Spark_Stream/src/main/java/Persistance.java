import com.mongodb.*;

public class Persistance {

    public DBCollection infoCollection;
    public  DBCollection counterCollection;
    public  DBCollection mesureCollection;
    public BasicDBObject info;

    public Persistance(){
        MongoClient mongo = new MongoClient("localhost",27017);
        DB db =mongo.getDB("HealthyData");
        infoCollection = db.getCollection("infos");
        counterCollection = db.getCollection("countCol");
        mesureCollection = db.getCollection("measure");
    }

    public void setInfo( long time, int value, Object id) {
        info = new BasicDBObject();
        info.append("_id", id);
        info.append("time", time);
        info.append("value", value);
    }
    public Object getId(){
        BasicDBObject searchQuery = new BasicDBObject("_id", "infoId");
        BasicDBObject updateQuery = new BasicDBObject("$inc",new BasicDBObject("seq", 1) );
        DBObject result = counterCollection.findAndModify(searchQuery, null, null,false, updateQuery, true, false);

        return result.get("seq");
    }
     public void insertInfo(long time, int value, String idMesure){
         Object id = getId();

         setInfo(time,value, id);
         infoCollection.insert(info);

         BasicDBObject query= new BasicDBObject();
         query.put("_id",idMesure);

         BasicDBObject update = new BasicDBObject();
         update.put("$push", new BasicDBObject("informations",id));

         mesureCollection.update(query, update, true, true);
     }
}
