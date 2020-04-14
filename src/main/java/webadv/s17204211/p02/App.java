package webadv.s17204211.p02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;
public class App {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
		writeFile();//预设账户密码
		
		System.out.println("请输入账号:");
		
		String no = input.nextLine();
		
		System.out.println("请输入密码:");
		
		String pwd = input.nextLine();
		
		login(no,pwd);
		
		
	}
	public static String sha256hex(String str) {
		return DigestUtils.sha256Hex(str);
	}
	//预设账户密码
	public static void writeFile() throws IOException {
		
		File file = new File("users.txt");
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		fileOutputStream.write(("17204211," + sha256hex("123456")).getBytes());
		
		fileOutputStream.close();
	}
	
	public static void login(String no,String pwd) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("users.txt"));
		
		String s = bf.readLine();		

		String[] temp = s.split(",");
		
		if( no.equals(temp[0]) && sha256hex(pwd).equals(temp[1]) ) {
			System.out.println("登陆成功");
		}
		else {
			System.out.println("登录失败");
		}
		
		bf.close();
	}
}

