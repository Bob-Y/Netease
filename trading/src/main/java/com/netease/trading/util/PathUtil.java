package com.netease.trading.util;

import java.io.File;

public class PathUtil {
	private static String separator = System.getProperty("file.separator");

	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "C:/Users/yubo/Desktop/NetEase";
		} else {
			basePath = "/Users/netease/work/image";
		}
		basePath = basePath.replace("/", separator);
		return basePath;
	}

	public static String getProductImagePath(long productId) {
		String imagePath = "/upload/images/item/product/" + productId + "/";
		return imagePath.replace("/", separator);
	}
	
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
}
