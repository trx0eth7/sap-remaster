package com.company.sapremaster;


import io.jmix.core.DataManager;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SapBaseTest {

    @Autowired
    SystemAuthenticator systemAuthenticator;

    @Autowired
    protected UnconstrainedDataManager dataManager;

    protected List<Object> entitiesToRemove = new ArrayList<>();

    @BeforeEach
    void setUp() {
        systemAuthenticator.begin("admin");
    }

    @AfterEach
    void tearDown() {
        systemAuthenticator.end();
        dataManager.remove(entitiesToRemove);
    }
}
