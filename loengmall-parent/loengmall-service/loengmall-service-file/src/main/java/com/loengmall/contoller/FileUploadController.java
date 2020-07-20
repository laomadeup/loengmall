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


    /**
     * <p>文件上传</p>
     *
     * * @param file
     *
     * @return com.loeng.entity.Result
     *
     * @author mapengliang
     * @createTime 2020/7/20 21:09
     */
    @PostMapping
    public Result upload(@RequestParam(value = "file") MultipartFile file) throws IOException, MyException {

        FastDFSFile fastDFSFile = new FastDFSFile(file.getOriginalFilename(),
                file.getBytes(),
                StringUtils.getFilenameExtension(file.getOriginalFilename()));

        String[] uploads = FastDFSUtil.upload(fastDFSFile);

        //拼接访问地址 url
//        String url = "http://47.75.255.86:8080/"+uploads[0]+"/"+uploads[1];
        String url = FastDFSUtil.getTrackerInfo()+"/"+uploads[0]+"/"+uploads[1];
        return new Result(true, StatusCode.OK,"上传成功",url);
    }

}
