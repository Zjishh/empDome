package com.zjh.emp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/****************************
 * @project empservice
 * @package com.zjh.emp
 * @className empApplication
 * @author Zjiah
 * @date 2023/9/15 10:49
 * @Description:   *
 ****************************/
@ServletComponentScan

@Slf4j
@SpringBootApplication
public class empApplication {

    public static void main(String[] args) {
        System.out.println();
        SpringApplication.run(empApplication.class, args);
        log.info("#\n" +
                "#         ┌─┐       ┌─┐\n" +
                "#      ┌──┘ ┴───────┘ ┴──┐\n" +
                "#      │                 │\n" +
                "#      │       ───       │\n" +
                "#      │  ─┬┘       └┬─  │\n" +
                "#      │                 │\n" +
                "#      │       ─┴─       │\n" +
                "#      │                 │\n" +
                "#      └───┐         ┌───┘\n" +
                "#          │         │\n" +
                "#          │         │\n" +
                "#          │         │\n" +
                "#          │         └──────────────┐\n" +
                "#          │                        │\n" +
                "#          │                        ├─┐\n" +
                "#          │                        ┌─┘\n" +
                "#          │                        │\n" +
                "#          └─┐  ┐  ┌───────┬──┐  ┌──┘\n" +
                "#            │ ─┤ ─┤       │ ─┤ ─┤\n" +
                "#            └──┴──┘       └──┴──┘\n" +
                "#                神兽保佑\n" +
                "#                代码无BUG!\n"
        );
    }

}
