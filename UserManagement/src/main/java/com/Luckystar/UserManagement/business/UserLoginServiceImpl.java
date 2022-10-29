package com.Luckystar.UserManagement.business;

import com.Luckystar.UserManagement.business.entity.QUserEntity;
import com.Luckystar.UserManagement.business.entity.UserEntity;
import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.exception.UserNotFoundException;
import com.Luckystar.UserManagement.ports.IUserLoginService;
import com.Luckystar.UserManagement.ports.UserRepository;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    @Override
    public UserDTO Login(UserDTO userDTO) throws UserNotFoundException,Exception{
        String proof=userDTO.getId();
        //密码明码转MD5
        String password=string2MD5(userDTO.getPassword());
        //查表匹配，ID可匹配MacID或邮箱
        QUserEntity qUserEntity=QUserEntity.userEntity;
        Predicate predicate1=null;
        //拼接带括号的sql语句按此方法
        predicate1=ExpressionUtils.and(predicate1,qUserEntity.password.eq(password));
        predicate1=ExpressionUtils.and(predicate1,qUserEntity.macId.eq(proof).or(qUserEntity.emailAddress.eq(proof)));
        try {
            List<UserEntity> userEntities=jpaQueryFactory.selectFrom(qUserEntity)
                    .where(predicate1)
                    .fetch();
            //匹配成功则返回ID和用户名
            if (userEntities.size()!=0){
                UserEntity userEntity=userEntities.get(0);
                userDTO=new UserDTO();
                userDTO.setUsername(userEntity.getUsername());
                userDTO.setId(userEntity.getId());
                userDTO.setType(userEntity.getType());
                return userDTO;
            }else{
                //匹配失败则返回空
//            return null;
                throw new UserNotFoundException("Invalid username or password!");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
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
