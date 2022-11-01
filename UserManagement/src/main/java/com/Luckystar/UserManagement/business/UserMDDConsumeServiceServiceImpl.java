package com.Luckystar.UserManagement.business;

import com.Luckystar.UserManagement.business.entity.QUserEntity;
import com.Luckystar.UserManagement.business.entity.UserEntity;
import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.ports.IUserMDDConsumeService;
import com.Luckystar.UserManagement.ports.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMDDConsumeServiceServiceImpl implements IUserMDDConsumeService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;


    /**
     * 消费MMD方法
     * @param userDTO
     * @return
     */
    @Override
    public boolean MDDConsume(UserDTO userDTO) {
        String macId=userDTO.getMacId();
        double MDD=userDTO.getMDD();
        //查询学生，学生不存在则返回false
        List<UserEntity> userEntities =userRepository.findByMacId(macId);
        if(userEntities.size()==0){
            return false;
        }else {
            //学生余额不足则返回false
            UserEntity userEntity=userEntities.get(0);
            if (userEntity.getMMD()<userDTO.getMDD()){
                return false;
            }else {
                //余额充足则扣费
                userEntity.setMMD(userEntity.getMMD()-userDTO.getMDD());
                userRepository.save(userEntity);
                return true;
            }
        }
    }

    /**
     * 增加MMD
     * @param userDTO
     * @return
     */
    @Override
    public boolean MDDAdd(UserDTO userDTO) {
        QUserEntity qUserEntity=QUserEntity.userEntity;
        String id=userDTO.getId();
        double MMD=userDTO.getMDD();
        //查询学生，学生不存在则返回false
        List<UserEntity> userEntities =jpaQueryFactory.selectFrom(qUserEntity)
                .where(qUserEntity.id.eq(id))
                .fetch();
        if(userEntities.size()==0){
            return false;
        }else {
            //学生存在则加钱
            UserEntity userEntity=userEntities.get(0);
            userEntity.setMMD(userEntity.getMMD()+MMD);
            userRepository.save(userEntity);
        }
        return true;
    }
}
