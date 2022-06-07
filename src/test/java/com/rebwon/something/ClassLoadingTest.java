package com.rebwon.something;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@Import(ClassLoadConfig.class)
public class ClassLoadingTest {

    @Autowired
    ApplicationContext ac;

    /**
     * Spring은 컴포넌트 스캔을 처리할 때, 클래스 로딩을 하지 않는다.
     */

    @Test
    void asm() {
        assertThat(ac).isNotNull();
        for (String beanName : ac.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

    @Test
    void name() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.rebwon.something.Beans");
        assertThat(aClass).isNotNull();
    }

}
