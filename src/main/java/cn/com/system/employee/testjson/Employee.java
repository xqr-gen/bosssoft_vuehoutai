package cn.com.system.employee.testjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class Employee {
    private String Name;
    private String Sex;
    private int Age;
}
