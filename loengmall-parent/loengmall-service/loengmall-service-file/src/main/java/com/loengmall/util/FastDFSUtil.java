package com.loengmall.util;

import com.loengmall.file.FastDFSFile;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.ServerInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mapengliang
 * @createTime 2020/7/20 10:39
 * @desc 实现FastDFS文件管理：
 * 文件上传
 * 文件下载
 * 文件删除
 * 文件信息获取
 * Storage信息获取
 * Tracker信息获取
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
     * <p>
     * * @param fastDFSFile:上传的文件信息封装
     *
     * @return void
     * @author mapengliang
     * @createTime 2020/7/20 11:08
     */
    public static String[] upload(FastDFSFile fastDFSFile) throws IOException, MyException {
        NameValuePair[] list_meta = new NameValuePair[1];
        list_meta[0] = new NameValuePair("author", fastDFSFile.getAuthor());
        TrackerServer trackerServer = getTrackerServer();

        //获取storageClient
        StorageClient storageClient = getStorageClient(trackerServer);

        /*通过StorageClient访问Storage，实现文件上传，并且获取文件上传后的信息
         * 1.文件上传的内容
         * 2.文件扩展名
         * 3.附加参数
         *
         * uploads[]:
         *   uploads[0]:文件上传所存储的Storage的组名字 group1
         *   uploads[1]:文件存储在Storage上的文件名
         *
         * */
        String[] uploads = storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), null);

        return uploads;
    }


    /**
     * <p>获取文件信息</p>
     * <p>
     * * @param groupName 文件的组名
     *
     * @param remoteFileName 文件的存储路径名
     * @return org.csource.fastdfs.FileInfo
     * @author mapengliang
     * @createTime 2020/7/20 21:11
     */
    public static FileInfo getFile(String groupName, String remoteFileName) throws IOException, MyException {
        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerServer trackerServer = getTrackerServer();
        //通过TrackerServer的连接信息可以获取Storage的连接信息，创建StorageClilent存储Storage的链接信息
        StorageClient storageClient = getStorageClient(trackerServer);
        //通过StorageClient访问Storage，获取文件的信息
        return storageClient.get_file_info(groupName, remoteFileName);
    }


    /**
     * <p>download</p>
     * <p>
     * * @param groupName 文件的组名
     *
     * @param remoteFileName 文件的存储路径名
     * @return java.io.InputStream
     * @author mapengliang
     * @createTime 2020/7/20 21:20
     */
    public static InputStream download(String groupName, String remoteFileName) throws IOException, MyException {

        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerServer trackerServer = getTrackerServer();
        //通过TrackerServer的连接信息可以获取Storage的连接信息，创建StorageClilent存储Storage的链接信息
        StorageClient storageClient = getStorageClient(trackerServer);
        //通过StorageClient访问Storage，实现文件下载
        byte[] bytes = storageClient.download_file(groupName, remoteFileName);
        return new ByteArrayInputStream(bytes);
    }


    /**
     * <p>delete</p>
     * <p>
     * * @param groupName      文件的组名
     *
     * @param remoteFileName 文件的存储路径名
     * @return void
     * @author mapengliang
     * @createTime 2020/7/20 21:27
     */
    public static void delete(String groupName, String remoteFileName) throws IOException, MyException {

        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerServer trackerServer = getTrackerServer();
        //通过TrackerServer的连接信息可以获取Storage的连接信息，创建StorageClilent存储Storage的链接信息
        StorageClient storageClient = getStorageClient(trackerServer);
        //通过StorageClient访问Storage，实现文件删除
        storageClient.delete_file(groupName, remoteFileName);


    }


    /**
     * <p>getStorages</p>
     * <p>
     * * @param
     *
     * @return org.csource.fastdfs.StorageServer
     * @author mapengliang
     * @createTime 2020/7/20 21:42
     */
    public static StorageServer getStorages() throws IOException {
        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient访问TrackerServer服务，获取连接信息
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getStoreStorage(trackerServer);

    }

    /**
     * <p>获取storage组的Ip和端口号</p>
     * <p>
     * * @param groupName
     *
     * @param remoteFileName
     * @return org.csource.fastdfs.ServerInfo
     * @author mapengliang
     * @createTime 2020/7/20 21:49
     */
    public static ServerInfo[] getServerInfo(String groupName, String remoteFileName) throws IOException {
        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient访问TrackerServer服务，获取连接信息
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
    }

    /**
     * <p>getTrackerInfo</p>
     * <p>
     * * @param
     *
     * @return java.lang.String
     * @author mapengliang
     * @createTime 2020/7/20 21:57
     */
    public static String getTrackerInfo() throws IOException {
        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerServer trackerServer = getTrackerServer();
        String ip = trackerServer.getInetSocketAddress().getHostString();
        int tracker_http_port = ClientGlobal.getG_tracker_http_port();
        return "http://" + ip + ":" + tracker_http_port;
    }


    /**
     * <p>getTrackerServer</p>
     * <p>
     * * @param
     *
     * @return org.csource.fastdfs.TrackerServer
     * @author mapengliang
     * @createTime 2020/7/20 22:08
     */
    private static TrackerServer getTrackerServer() throws IOException {
        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient访问TrackerServer服务，获取连接信息
        return trackerClient.getConnection();
    }


    /**
     * <p>通过TrackerServer的连接信息可以获取Storage的连接信息，创建StorageClilent存储Storage的链接信息</p>
     * <p>
     * * @param trackerServer
     *
     * @return org.csource.fastdfs.StorageClient
     * @author mapengliang
     * @createTime 2020/7/20 22:09
     */
    private static StorageClient getStorageClient(TrackerServer trackerServer) {
        return new StorageClient(trackerServer, null);
    }


    public static void main(String[] args) throws IOException, MyException {
      /*  FileInfo fileInfo = getFile("group1", "M00/00/00/rB8UkF8VjduAdVFFAA2gX7tWXf4111.jpg");
        System.out.println(fileInfo.getSourceIpAddr());
        System.out.println(fileInfo.getFileSize());*/

      /*  InputStream is = download("group1", "M00/00/00/rB8UkF8VjduAdVFFAA2gX7tWXf4111.jpg");

        byte[] buffer = new byte[1024];

        FileOutputStream os = new FileOutputStream("D:/1.jpg");
        while (is.read(buffer) != -1){
            os.write(buffer);
        }
        os.flush();
        os.close();
        is.close();*/

        // delete("group1", "M00/00/00/rB8UkF8VjduAdVFFAA2gX7tWXf4111.jpg");

     /*   System.out.println(getStorages().getStorePathIndex());
        System.out.println(getStorages().getInetSocketAddress().getAddress());*/


      /*  ServerInfo[] groups = getServerInfo("group1", "rB8UkF8Vnb-ASlSMAC9s7qiVcgU992.jpg");
        for (ServerInfo group : groups) {
            System.out.println(group.getIpAddr());
            System.out.println(group.getPort());

        }*/

        System.out.println(getTrackerInfo());

    }

}
