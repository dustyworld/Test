package test.jim.load;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class LoadFiles {

	public static void main(String[] args) {
			Properties prop = new Properties();     
			try{
				//��ȡ�����ļ�
				InputStream in = new BufferedInputStream (new FileInputStream("C:/EmailTest/server_config.external_itg.dcc"));
				prop.load(in);     ///���������б�
				//Iterator<String> it=prop.stringPropertyNames().iterator();
				System.out.println("MTP_ORDER_NUMBER:"+prop.getProperty("MTP_ORDER_NUMBER"));
//				while(it.hasNext()){
//				  String key=it.next();
//				  System.out.println(key+":"+prop.getProperty(key));
//				}
				in.close();
				            
				///�������Ե�b.properties�ļ�
//				FileOutputStream oFile = new FileOutputStream("b.properties", true);//true��ʾ׷�Ӵ�
//				prop.setProperty("phone", "10086");
//				prop.store(oFile, "The New properties file");
//				oFile.close();
			}
			catch(Exception e){
			    System.out.println(e);
			}
	    } 
    }
