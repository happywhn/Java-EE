package com.whn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/15 21:33
 * @description 文件上传
 */
@Controller
public class FileUploadController {
    @RequestMapping("/toFileupload")
    public String toFileUpload() {
        return "fileUpload";
    }
    /**
     * 执行文件上传
     */
    @RequestMapping("/fileUpload")
    public String handleFormUpload(@RequestParam("name")String name,
                                   @RequestParam("uploadfile")List<MultipartFile> uploadfile,
                                   HttpServletRequest request) {
        // 判断文件上传是否存在
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            // 循环输出上传文件
            for (MultipartFile file:uploadfile) {
                // 获取上传文件的原始目录
                String originalFilename = file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                String dirPath =
                        request.getSession().getServletContext().getRealPath("/upload");
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                // 使用UUID重新命名上传的文件名称(上传人_uuid_原始文件名称)
                String newFilename = name+"_"+UUID.randomUUID()+"_"+originalFilename;
                try {
                    // 使用MultipartFile接口的方法完成文件上传的指定位置
                    file.transferTo(new File(dirPath+newFilename));
                }catch (Exception e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            // 跳转到成功页面
            return "success";
        }else {
            return "error";
        }
    }
}
