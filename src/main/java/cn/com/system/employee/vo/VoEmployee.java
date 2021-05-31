package cn.com.system.employee.vo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/*
a）序列化时，只对对象的状态进行保存，而不管对象的方法；
b）当一个父类实现序列化，子类自动实现序列化，不需要显式实现Serializable接口；
c）当一个对象的实例变量引用其他对象，序列化该对象时也把引用对象进行序列化；
d）并非所有的对象都可以序列化。
e) 序列化会忽略静态变量，即序列化不保存静态变量的状态。静态成员属于类级别的，不能序列化。添加了static、transient关键字后的变量不能序列化。
a）当你想把的内存中的对象状态保存到一个文件中或者数据库中，以便可以在以后重新创建精确的副本；
b）当你想用套接字在网络上传送对象的时候(从一个应用程序域发送到另一个应用程序域中)；
c）当你想通过RMI传输对象的时候
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoEmployee implements java.io.Serializable{
    private String empId;
    private String empName;
    @JsonIgnore
    private transient String empPassword;
    private String empSex;
    private String empAge;
    private String empBirthday;
}
