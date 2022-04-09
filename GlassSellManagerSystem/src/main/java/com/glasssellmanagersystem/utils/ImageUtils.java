//package com.glasssellmanagersystem.utils;
//
//
//import cn.lzx.university_shop.dto.ImageTemp;
//import net.coobird.thumbnailator.Thumbnails;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//
//
//public class ImageUtils {
//
//
//    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//    private static final Random r = new Random();
//    private static Logger logger = LoggerFactory.getLogger(ImageUtils.class);
//
//    //将前端传来的CommonsMultipartFile转换成File
//    public static File transToFile(MultipartFile cfile){
//        String filename = cfile.getOriginalFilename();
//        File file = new File(filename);
//        try {
//            cfile.transferTo(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//            logger.error("图片转换失败:"+e.toString());
//        }
//        return file;
//    }
//
//    //上传图片
//    public static String saveImg(ImageTemp imageTemp, String targetAddr) throws IOException {
//        //对新生成的文件进行相应处理 规范文件名
//        String newFileName = getRandomFileName();
//        String extension = getFileExtension(imageTemp.getImgName());
//        makeDirPath(targetAddr);
//        String realAddr = targetAddr + newFileName + extension;
//        //目标文件
//        File dest = new File(PathUtils.getImgBasePath()+realAddr);
//        Thumbnails.of(imageTemp.getInputStream()).size(200,200)
//                .outputQuality(0.8f)
//                .toFile(dest);
//        return PathUtils.getImgBasePath()+realAddr;
//    }
//
//    //删除图片
//    /**
//     * storePath是文件路径还是目录路径
//     * 如果是文件路径则删除该文件
//     * 如果是目录路径则删除该目录下所有文件
//     * @param storePath
//     */
//    public static void deleteImg(String storePath){
//        File fileOrDire = new File(PathUtils.getImgBasePath()+storePath);
//        if (fileOrDire.exists()){
//            if (fileOrDire.isDirectory()){
//                //是目录路径 删除全部文件
//                File[] files = fileOrDire.listFiles();
//                for (File file : files){
//                    file.delete();
//                }
//            }
//            //是文件
//            fileOrDire.delete();
//        }
//    }
//
//
//    //创建目标路径上的目录
//    private static void makeDirPath(String targetAddr) {
//        String realPath = PathUtils.getImgBasePath()+targetAddr;
//        File dir = new File(realPath);
//        if (!dir.exists()){
//            dir.mkdirs();
//        }
//    }
//
//    //获取文件扩展名
//    private static String getFileExtension(String ImageName) {
//        return ImageName.substring(ImageName.lastIndexOf("."));
//    }
//
//    //生成随机的文件名  随机五位数 + 时间
//    private static String getRandomFileName() {
//        //获取随机五位数
//        int randnum = r.nextInt(89999) + 10000;
//        String nowTime = sDateFormat.format(new Date());
//        return nowTime + randnum;
//    }
//
//
//    //Demo
//    public static void main(String[] args) throws IOException {
//        Thumbnails.of(new File("G:\\001.jpg"))
//                .size(200,200)
//                .outputQuality(0.8f)
//                .toFile("C:\\Users\\67409\\Desktop\\图片\\商品缩略图\\demo2.jpg");
//}
