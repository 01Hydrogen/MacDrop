package com.Luckystar.UserManagement.business;

import com.Luckystar.UserManagement.business.entity.QUserEntity;
import com.Luckystar.UserManagement.business.entity.UserEntity;
import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.ports.IUserRegisterService;
import com.Luckystar.UserManagement.ports.UserRegisterRepository;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserRegisterServiceImpl implements IUserRegisterService {

    @Autowired
    private UserRegisterRepository userRegisterRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    /**
     * 用户注册方法
     * @param userDTO
     * @return
     */
    @Override
    public boolean Register(UserDTO userDTO){
        QUserEntity qUserEntity=QUserEntity.userEntity;
        //查id是否重复
        boolean checkResult1=!userRegisterRepository.existsById(userDTO.getId());
        if(checkResult1==false){
            return false;
        }
        //查email是否重复
        Predicate predicate=null;
        predicate= ExpressionUtils.and(predicate,qUserEntity.emailAddress.eq(userDTO.getEmailAddress()));
        List<UserEntity>userEntities=jpaQueryFactory.selectFrom(qUserEntity)
                .where(predicate)
                .fetch();
        if(userEntities.size()!=0){
            return false;
        }
        //账号不重复
        //DTO转实体类
        UserEntity userEntity=new UserEntity(userDTO);
        //密码加密
        userEntity.setPassword(string2MD5(userEntity.getPassword()));
        userRegisterRepository.save(userEntity);
        return true;

    }
    @Override
    public boolean DeleteUser(UserDTO userDTO){
        try {
            userRegisterRepository.deleteById(userDTO.getId());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }




    /**
     * String转MD5
     * @param string
     * @return
     */
    private String string2MD5 (String string){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(string.getBytes("UTF-8"));
            byte[] encryption = md5.digest();

            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++) {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
                    strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                } else {
                    strBuf.append(Integer.toHexString(0xff & encryption[i]));
                }
            }

            return strBuf.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
