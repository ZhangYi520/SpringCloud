package com.zy.zy_filesystem.util;

import java.text.DecimalFormat;

public class Change {
	
	//文件大小格式转换
	public String ChangeSize(long s) {
	 	final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(s) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(s / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}
}
