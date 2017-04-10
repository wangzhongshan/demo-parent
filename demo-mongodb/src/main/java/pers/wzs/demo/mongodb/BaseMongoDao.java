package pers.wzs.demo.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;

/**
 * Created by wangzhongshan on 2017/3/29.
 */
public class BaseMongoDao {

    protected static final MongoClient mongoClient = new MongoClient();
    //        MongoClient mongoClient = new MongoClient("localhost", 27017);

    public static void main(String[] args) {
        MongoDatabase database = mongoClient.getDatabase("wzs");
        MongoCollection<Document> collection = database.getCollection("test");
//        Document document = new Document("name", "MongoDB1").append("type", "database").append("count", 1).append("versions", Arrays.asList("3.2", "3.3", "3.4")).append("info", new Document("x", 203).append("y", 102));
//        collection.insertOne(document);
//        System.out.println(collection.count());
//        Document first = collection.find().first();
//        System.out.println(first.toJson());

//        MongoCursor<Document> cursor = collection.find().iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }

//        Document document1 = collection.find(eq("name", "MongoDB1")).first();
//        System.out.println(document1.toJson());
//        FindIterable<Document> documents = collection.find(eq("name", "MongoDB"));
//        documents.forEach((Block<? super Document>) document -> System.out.println(document.toJson()));

//        collection.updateOne(eq("name", "MongoDB"), new Document("$set", new Document("name", "MongoDB2")));
//        UpdateResult updateResult = collection.updateOne(eq("name", "MongoDB"), Updates.inc("count", 222));
//        System.out.println(updateResult.getModifiedCount());

//        collection.deleteOne(eq("name", "MongoDB2"));

//        collection.createIndex(new Document("name", -1));
//        collection.createIndex(Indexes.descending("name"));
        for (Document index : collection.listIndexes()) {
            System.out.println(index.toJson());
        }
    }
}
