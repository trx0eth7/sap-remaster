package com.company.sapremaster.service;

import com.company.sapremaster.app.EntityConfigBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Vasiliev
 */
@Component
public class EntityConfigService {

    @Autowired
    ObjectProvider<EntityConfigBean> providerEntityConfigBean;

    public String getEntityConfig() {
        return providerEntityConfigBean.getObject().getStr();
    }
}
