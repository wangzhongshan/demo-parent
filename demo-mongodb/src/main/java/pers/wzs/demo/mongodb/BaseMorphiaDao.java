package pers.wzs.demo.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import pers.wzs.demo.mongodb.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhongshan on 2017/3/29.
 */
public class BaseMorphiaDao {
    public static void main(String[] args) {
        final Morphia morphia = new Morphia();
//        Mapper mapper = morphia.getMapper();
        morphia.mapPackage("pers.wzs.demo.mongodb.model");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
//        datastore.ensureIndexes();

//        final Employee elmer = new Employee("wzs", 100000.2);
//        List<Employee> employees = new ArrayList<>();
//        elmer.setDirectReports(employees);
//
//        final Employee daffy = new Employee("Daffy Duck", 40000.0);
//        datastore.save(daffy);
//        final Employee pepe = new Employee("Pep Le Pew", 25000.0);
//        datastore.save(pepe);
//
//        elmer.getDirectReports().add(daffy);
//        elmer.getDirectReports().add(pepe);
//
//        datastore.save(elmer);
//        Query<Employee> query = datastore.createQuery(Employee.class);
//        List<Employee> employees = query.asList();
//        System.out.println(employees);
//        List<Employee> employees = datastore.createQuery(Employee.class).field("name").equal("wzs").asList();
//        System.out.println(employees);

//        Query<Employee> query = datastore.createQuery(Employee.class).filter("salary <=", 40000);
//        UpdateOperations<Employee> salary = datastore.createUpdateOperations(Employee.class).inc("salary", 111);
//        UpdateResults updateResults = datastore.update(query, salary);
//        System.out.println(updateResults.getUpdatedCount());

        Query<Employee> filter = datastore.createQuery(Employee.class).filter("name", "wzs");
        WriteResult writeResult = datastore.delete(filter);
        System.out.println(writeResult.getN());
    }
}
