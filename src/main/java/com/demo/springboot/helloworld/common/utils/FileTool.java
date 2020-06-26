package com.demo.springboot.helloworld.common.utils;
/*编写人：
编写功能：储存图片
编写时间：6月12-13日*/
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTool {
	/**
	 * 写入文件到本地
	 * @param bytes
	 * @param path
	 * @throws IOException 
	 */
	public static void writeFile(byte[] bytes, String path) throws RuntimeException {
		//判断文件夹路径是否存在 不存在则创建
		FileOutputStream out = null;
		try {
			String folder=path.substring(0,path.lastIndexOf("/"));
			File file=new File(folder);
			if(!file.exists()){
				file.mkdirs();
			}
			//创建空文件
			File newFile=new File(path);
			newFile.createNewFile();
			//开始写入文件
			out= new FileOutputStream(path);
			out.write(bytes);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 传一个路径 创建一个文件
	 * @param filePath
	 * @throws IOException 
	 */
	public static void createFile(String filePath) throws IOException{
		String folder=filePath.substring(0,filePath.lastIndexOf("/"));
		File file=new File(folder);
		if(!file.exists()){
			file.mkdirs();
		}
		//创建空文件
		File newFile=new File(filePath);
		newFile.createNewFile();
	}
}
