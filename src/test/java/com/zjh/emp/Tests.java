package com.zjh.emp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


/****************************
 * @project empservice
 * @package com.zjh.emp
 * @className Tests
 * @author Zjiah
 * @date 2023/10/9 8:45
 * @Description:   *
 ****************************/
@SpringBootTest
public class Tests {
    @Test
    public void uuid(){
        for (int i = 0; i < 100; i++) {
            String s = UUID.randomUUID().toString();
            System.out.println(s);
        }
    }


}
