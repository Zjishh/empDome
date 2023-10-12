package com.zjh.emp.controller;



import com.zjh.emp.pojo.Emp;
import com.zjh.emp.pojo.Result;
import com.zjh.emp.service.EmpService;
import com.zjh.emp.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/****************************
 * @project empservice
 * @package com.zjh.emp.controller
 * @className LoginController
 * @author Zjiah
 * @date 2023/10/10 18:03
 * @Description:   *
 ****************************/
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录"+emp);
        Emp e = empService.login(emp);

        if (e !=null){
            Map<String,Object> c = new HashMap<>();
            c.put("username",emp.getUsername());
            c.put("id",emp.getId());
            c.put("name",emp.getName());
            String s = JwtUtils.generateJwt(c);
            return Result.success(s);
        }else{
            return Result.error("用户名或密码错误");
        }

    }


}
