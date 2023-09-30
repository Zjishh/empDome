package com.zjh.emp.controller;

import com.zjh.emp.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/****************************
 * @project empservice
 * @package com.zjh.emp.controller
 * @className UploadController
 * @author Zjiah
 * @date 2023/9/26 20:55
 * @Description:   *
 ****************************/

@RestController
@Slf4j
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) {
        log.info("文件上传：{}，{}，{}", username, age, image);
        return Result.success();
    }
}
