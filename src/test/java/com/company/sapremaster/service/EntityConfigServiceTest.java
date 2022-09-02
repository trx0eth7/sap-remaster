package com.company.sapremaster.service;

import com.company.sapremaster.SapBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EntityConfigServiceTest extends SapBaseTest {

    @Autowired
    EntityConfigService entityConfigService;

    @Test
    void getEntityConfig() {
        System.out.println("MY STR_1:" + entityConfigService.getEntityConfig());
        System.out.println("MY STR_2:" + entityConfigService.getEntityConfig());
        System.out.println("MY STR_3:" + entityConfigService.getEntityConfig());
        System.out.println("MY STR_4:" + entityConfigService.getEntityConfig());
        System.out.println("MY STR_5:" + entityConfigService.getEntityConfig());
        System.out.println("MY STR_6:" + entityConfigService.getEntityConfig());
    }
}