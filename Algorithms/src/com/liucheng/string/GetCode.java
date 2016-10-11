package com.liucheng.string;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetCode {

	public static void main(String[] args) {
		int max=0;
		String maxStr=null;
		String path="D:\\words.txt";
		try {
			analysisFile(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		culculateCode(path);
		System.out.println("最高分数为："+maxStr);
	}

	private static String[] analysisFile(String path) throws Exception {
		String[] words = null;
		File file = new File(path);
		if(file.isFile() && file.exists()){ //判断文件是否存在
	        FileInputStream fileInputStream = new FileInputStream(file);  
	        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);  
	        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);  
	        BufferedReader input = new BufferedReader(inputStreamReader, 10*1024*1024);  
	        String line = null;  
	        while((line = input.readLine()) != null){
	        	words=line.split(",");
	        }
		} 
		return words;
	}

	private static int culculateCode(String str) {
		char[] cArr = new char[] { 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int code=0;
		for (int i = 1; i <= str.length(); i++) {
			char c=str.subSequence(i - 1, i).charAt(0);
			code=code+Arrays.binarySearch(cArr, c);
		}
		return code;
	}

}
