package com.zjh.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/****************************
 * @project empservice
 * @package com.zjh.emp
 * @className empApplication
 * @author Zjiah
 * @date 2023/9/15 10:49
 * @Description:   *
 ****************************/
@SpringBootApplication
public class empApplication {

    public static void main(String[] args) {
        SpringApplication.run(empApplication.class, args);
    }

}
