package com.company.sapremaster.app;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author Alexander Vasiliev
 */
@Component
//@Scope(value = SCOPE_PROTOTYPE)
public class EntityConfigBean {
    private final String randomStr;

    public EntityConfigBean() {
        char[][] pairs = {{'0', '9'}};

        this.randomStr = new RandomStringGenerator.Builder()
                .withinRange(pairs)
                .build().generate(10);
    }

    public String getStr() {
        return randomStr;
    }
}
