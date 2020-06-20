package com.demo.springboot.helloworld.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


public class AttrFileTool {
	
	/**
	 * 附件地址目录
	 */
	public static final String NGINXPATH="C:\\nginx/static";
	public static final String path=NGINXPATH+"/image/";

	public static final String FWPATH="http://localhost:8090";






	public String saveFile(MultipartFile file) throws RuntimeException,
			IOException {
		if (file == null) {
			return null;
		}

		// 上传文件类型 声明
		String fileType;
		// 存到本地的文件名 声明
		String fileName = null;
		// 判断是否有文件
		if (file == null || file.isEmpty()) {
			return null;
		}
		// 临时变量 用来保存路径
		if(StringUtils.isEmpty(file.getOriginalFilename())){
			throw new RuntimeException("上传文件名不能为空");
		}
		String tempPath;
		if(file.getOriginalFilename()==null||"".equals(file.getOriginalFilename())||!file.getOriginalFilename().contains(".")){
			throw new RuntimeException("上传文件名是:"+file.getOriginalFilename()+"。不符合规范!");
		}
		fileType = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf("."),
				file.getOriginalFilename().length());
		fileName = UUID.randomUUID().toString() + fileType;
		// 原始图片路径
		tempPath = path + fileName;
		// 写入文件
		//System.out.println("-------------------------"+tempPath);
		FileTool.writeFile(file.getBytes(), tempPath);
		return "/image/" + fileName;
	}


	
}
