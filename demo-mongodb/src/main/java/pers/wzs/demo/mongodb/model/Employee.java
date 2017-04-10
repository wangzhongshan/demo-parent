package pers.wzs.demo.mongodb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.List;

/**
 * Created by wangzhongshan on 2017/4/7.
 */
@NoArgsConstructor
@Data
@Entity
@Indexes(
        @Index(value = "salary", fields = @Field("salary"))
)
public class Employee {
    @Id
    private ObjectId id;
    private String name;
    private Double salary;
    @Reference
    private Employee manager;
    @Reference
    private List<Employee> directReports;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }
}
