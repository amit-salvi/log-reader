package com.log.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LogReader {

	public static void readFile(String fileName){
		try{
			File file = new File(fileName);
			boolean keepReading = true;
			String line="";
			if(!file.exists()){
				System.out.println("File does not exists : " + fileName);
				System.out.println("Please provide the exact path of the log file");
				System.exit(0);
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(keepReading){
				line = br.readLine();
				if(line==null){
					Thread.sleep(200);
				} else{
					System.out.println(line);
				}
			}
			br.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		if(args == null || args.length==0){
			System.out.println("********************************************");
			System.out.println("You need to enter the name of the file");
			System.out.println("Command Usage: java LogReader \"file name\" ");
			System.out.println("********************************************");
		} else{
			readFile(args[0]);
		}
		
	}
}
