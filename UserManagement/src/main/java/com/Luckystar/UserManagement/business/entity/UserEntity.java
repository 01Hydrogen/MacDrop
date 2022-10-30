package com.Luckystar.UserManagement.business.entity;

import com.Luckystar.UserManagement.dto.UserDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USERTABLE")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Getter @Setter
public class UserEntity {

    public UserEntity(){

    }

    /**
     * 构造方法
     * @param userDTO
     */
    public UserEntity(UserDTO userDTO){
        if (null!=userDTO.getId()){
            this.id=userDTO.getId();
        }
        if(null!=userDTO.getMacId()){
            this.macId=userDTO.getMacId();
        }
        if(null!=userDTO.getUsername()){
            this.username=userDTO.getUsername();
        }
        this.type=userDTO.getType();
        if(null!=userDTO.getPassword()){
            this.password=userDTO.getPassword();
        }
        if (null!=userDTO.getEmailAddress()){
            this.emailAddress=userDTO.getEmailAddress();
        }
        if(userDTO.getMMD()!=0){
            this.MMD=userDTO.getMMD();
        }
    }

    /**
     * 自动生成ID
     */
    @Id
    @Column(name = "ID",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    /**
     * 学生填写MacID
     */
    @Column(name = "MAC_ID")
    private String macId;

    /**
     * 用户名
     */
    @Column(name = "USERNAME",length = 32)
    private String username;

    /**
     * 用户类型，0为超管，1为学生，2为餐厅，3为骑手
     */
    @Column(name = "TYPE")
    private int type;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 电子邮件
     */
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    /**
     * McMasterDollar
     */
    @Column(name = "MMD")
    private double MMD;
}
