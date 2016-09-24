package com.liucheng.dynamicProgramming;

/**
 * DynaicProgramming¶¯Ì¬¹æ»®
 * @author Administrator
 *
 */
public class DP {
	public static void main(String[] args) {
		int[] c={0,5,1,2,10,6,2};
		int[] f=new int[7];
		f[0]=0;f[1]=c[1];
		for(int i=2;i<=6;i++){
			f[i]=max(c[i]+f[i-2],f[i-1]);
		}
		for(int i:f){
			System.out.print(" "+i+" ");
		}
	}

	private static int max(int i, int f) {
		return i<f?f:i;
	}

}
