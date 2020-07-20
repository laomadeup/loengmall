package com.loengmall.util;

import com.loengmall.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author mapengliang
 * @createTime 2020/7/20 10:39
 * @desc 实现FastDFS文件管理：
 *  文件上传
 *  文件下载
 *  文件删除
 *  文件信息获取
 *  Storage信息获取
 *  Tracker信息获取
 */
public class FastDFSUtil {

    static {

        try {
            String fileName = new ClassPathResource("fdfs_client.conf").getPath();
            ClientGlobal.init(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * <p>文件上传</p>
     *
     * * @param fastDFSFile:上传的文件信息封装
     *
     * @return void
     *
     * @author mapengliang
     * @createTime 2020/7/20 11:08
     */
    public static void upload(FastDFSFile fastDFSFile) throws IOException, MyException {
        NameValuePair[] list_meta = new NameValuePair[1];
        list_meta[0] = new NameValuePair("author",fastDFSFile.getAuthor());
        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient访问TrackerServer服务，获取连接信息
        TrackerServer trackerServer = trackerClient.getConnection();
        //通过TrackerServer的连接信息可以获取Storage的连接信息，创建StorageClilent存储Storage的链接信息
        StorageClient storageClient = new StorageClient(trackerServer, null);
        /*通过StorageClient访问Storage，实现文件上传，并且获取文件上传后的信息
        * 1.文件上传的内容
        * 2.文件扩展名
        * 3.附加参数
        * */
        storageClient.upload_file(fastDFSFile.getContent(),fastDFSFile.getExt(),null);
        
    }
    
    
    
}
