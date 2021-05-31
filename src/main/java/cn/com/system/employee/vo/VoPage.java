package cn.com.system.employee.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor
public class VoPage implements java.io.Serializable{

    private int pageNO;
    private int limit;
    private String idS;

}
