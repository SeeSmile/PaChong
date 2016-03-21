package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InfoConfig {
	
	private String page_cwq;
	private String page_wby;
	private String config;
	
	public InfoConfig() {
		this.config = getConfig();
	}
	
	private String getConfig() {
		String text = "";
		File file = new File("./config/info");
		   BufferedReader reader = null;
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	                text += tempString;
	               
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                	
	                }
	            }
	        }
	        return text;
	}
	
	public void setCwqConfig(int page) {
		
	}
	
	public void setWbyConfig(int page) {
		
	}
}
