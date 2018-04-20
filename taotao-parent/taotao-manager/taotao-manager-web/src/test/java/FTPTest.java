import org.apache.commons.net.ftp.FTPClient;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * @author:binblink
 * @Description
 * @Date: Create on  2018/4/19 22:50
 * @Modified By:
 * @Version:1.0.0
 **/
public class FTPTest {


    public static void testFTP() throws IOException {

        FTPClient ftpClient = new FTPClient();

        ftpClient.connect("192.168.80.129",21);

        ftpClient.login("ftpuser","123456");

        FileInputStream fis = new FileInputStream("E:\\图片\\bb.jpg");

//        ftpClient.changeWorkingDirectory("/home/ftpuser/gif");
       String   basePath = "/home/ftpuser";
        String   filePath = "/2018/04/20";
//        ftpClient.makeDirectory("www");
        System.out.println(ftpClient.changeWorkingDirectory("/2018/04/20"));
//        System.out.println(ftpClient.listFiles());
//        //切换到上传目录
        if (!ftpClient.changeWorkingDirectory(filePath)) {
            //如果目录不存在创建目录
            String[] dirs = filePath.split("/");
            String tempPath = basePath;
            for (String dir : dirs) {
                if (null == dir || "".equals(dir)){
                    continue;
                }
                tempPath += "/" + dir;
                if (!ftpClient.changeWorkingDirectory(dir)) {
                    if (!ftpClient.makeDirectory(dir)) {

                    } else {
                        ftpClient.changeWorkingDirectory(dir);
                    }
                }
            }
        }

        ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

        ftpClient.storeFile("a.jpg",fis);

        ftpClient.logout();

    }


    public static void main(String[] args) {

        try {
            testFTP();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
