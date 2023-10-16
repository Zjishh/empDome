package com.zjh.emp;

import com.zjh.emp.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/****************************
 * @project empservice
 * @package com.zjh.emp
 * @className testtime
 * @author Zjiah
 * @date 2023/10/13 8:34
 * @Description:   *
 ****************************/
@SpringBootTest
public class testtime {
    @Test
    public void gettimetest(){
        JwtUtils jwtUtils = new JwtUtils();
        jwtUtils.gettime();
    }
}
