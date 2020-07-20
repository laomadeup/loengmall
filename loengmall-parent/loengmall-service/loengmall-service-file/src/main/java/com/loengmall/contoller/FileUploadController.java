package com.loengmall.contoller;

import com.loeng.entity.Result;
import com.loeng.entity.StatusCode;
import com.loengmall.file.FastDFSFile;
import com.loengmall.util.FastDFSUtil;
import org.csource.common.MyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author mapengliang
 * @createTime 2020/7/20 12:14
 * @desc
 */
@RestController
@RequestMapping(value = "/upload")
@CrossOrigin
public class FileUploadController {


    @PostMapping
    public Result upload(@RequestParam(value = "file") MultipartFile file) throws IOException, MyException {

        FastDFSFile fastDFSFile = new FastDFSFile(file.getOriginalFilename(),
                file.getBytes(),
                StringUtils.getFilenameExtension(file.getOriginalFilename()));

        FastDFSUtil.upload(fastDFSFile);
        return new Result(true, StatusCode.OK,"上传成功");
    }

}
