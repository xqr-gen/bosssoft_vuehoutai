package cn.com.system.employee.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoUserInfo implements java.io.Serializable{
    private List<String> roles;
    private String introducation;
    private String avatar;
    private String name;

}
