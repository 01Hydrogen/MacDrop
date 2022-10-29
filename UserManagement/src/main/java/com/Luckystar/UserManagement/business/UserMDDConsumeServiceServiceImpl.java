package com.Luckystar.UserManagement.business;

import com.Luckystar.UserManagement.business.entity.UserEntity;
import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.ports.IUserMDDConsumeService;
import com.Luckystar.UserManagement.ports.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMDDConsumeServiceServiceImpl implements IUserMDDConsumeService {

    @Autowired
    UserRepository userRepository;


    /**
     * 消费MDD方法
     * @param userDTO
     * @return
     */
    @Override
    public boolean MDDConsume(UserDTO userDTO) {
        String macId=userDTO.getMacId();
        double MDD=userDTO.getMMD();
        //查询学生，学生不存在则返回false
        List<UserEntity> userEntities =userRepository.findByMacId(macId);
        if(userEntities.size()==0){
            return false;
        }else {
            //学生余额不足则返回false
            UserEntity userEntity=userEntities.get(0);
            if (userEntity.getMMD()<userDTO.getMMD()){
                return false;
            }else {
                //余额充足则扣费
                userEntity.setMMD(userEntity.getMMD()-userDTO.getMMD());
                userRepository.save(userEntity);
                return true;
            }
        }

    }
}
