package io.github.cloudadc.as3.pojo;

public class TMP {

	public static void main(String[] args) {

		int cur = 0;
		for(int i = 0 ; i < 1448 ; i ++) {
			System.out.print(cur++);
			if (cur == 9) {
				cur = 0 ;
			}
		}
	}

}
