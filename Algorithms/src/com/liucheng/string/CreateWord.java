package com.liucheng.string;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateWord {
	
	static final int onceMaxNum=500000;
	
	public static void main(String[] args) {
		try {
			long start=System.currentTimeMillis();
			writeWordsToFile("D:\\words.txt", 10000000);
			long end=System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void writeWordsToFile(String path,int wordsNum) throws IOException{
		File file=new File(path);
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter fw=new FileWriter(file);
		String s="";
		if(wordsNum>=onceMaxNum){
			int[] arr=checkWordsNum(wordsNum);
			//System.out.println(arr[0]+"--"+arr[1]);
			for(int i=0;i<arr[0];i++){
				 s=createWord(onceMaxNum);
				 fw.write(s);
				 //创建单词方法里面50w个最后一个就没有逗号了，所以在这边补上
				 if(arr[1]>0||arr[0]>1){
					 fw.write(",");
				 }
				 fw.flush();
			}
			s=createWord(arr[1]);
			fw.write(s);
			fw.flush();
			fw.close();
			System.out.println("ok!");
		}else{
			s=createWord(wordsNum);
			fw.write(s);
			fw.flush();
			fw.close();
			System.out.println("ok1!");
		}
		
	}
	
	public static int createRandomNum(int min, int max) {
		int range = (max - min) + 1;
		int random = (int) ((Math.random() * range) + min);
		return random;
	}
	//TODO 
	public static int[] checkWordsNum(int wordsNum){
		int[] arr=null;
		if(wordsNum>onceMaxNum){
			double a=(double)wordsNum/onceMaxNum;
			int b=(int)a;
			double c=a-b;
			int d=(int) (c*onceMaxNum);
			arr=new int[]{b,d};
		}
		return arr;
	}
	/**
	 * 生成指定数量的字符串用逗号隔开
	 * @param wordNum
	 * @return
	 */
	public static String createWord(int wordNum){
		char[] cArr = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		StringBuilder word=new StringBuilder();
		for(int j=0;j<wordNum;j++){
			for (int i = 0, length = createRandomNum(5, 10); i < length; i++) {
				char c = cArr[createRandomNum(0, 25)];
				word.append(c);
				//最后一个单词不需要逗号
				if(j!=wordNum-1){
					if ((length - 1) == i) {
						word.append(",");
					}
				}
			}
			//20个单词换一行
			if(j%20==0&&j!=0){
				word.append("\r\n");
			}
		}
		return word.toString();
	}
}
