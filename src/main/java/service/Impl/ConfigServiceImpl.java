package service.Impl;

import POJO.ConfigEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ConfigService;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("configService") //进行注入
public class ConfigServiceImpl implements ConfigService {
    public ConfigServiceImpl() {
    }
    public List<ConfigEntity> findAll(){

        return null;
    }
}
