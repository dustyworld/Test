package test.jim.sendMsg;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.bcloud.msg.http.HttpSender;

public class HttpSenderTest {
	//创蓝sdk
	
	String url = "http://222.73.117.158/msg/HttpBatchSendSM";// 应用地址
	String account = "jiekou-clcs-02";// 账号
	String pswd = "Tch112233";// 密码
	String mobile = "18996473229,15000042335";// 手机号码，多个号码使用","分割
	String msg = "您好，您的验证码是123456";// 短信内容
	boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
	String product = null;// 产品ID
	String extno = null;// 扩展码
	public static void main(String[] a) throws Exception{
//		new HttpSenderTest().sendMsgs();
		new HttpSenderTest().sendMsg01();
		System.out.println("send successful");
	}
	public void sendMsg01() throws Exception{
		try {
			String returnString = HttpSender.batchSend(url, account, pswd, mobile, msg, needstatus, product, extno);
			System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
	public void sendMsg(){
		PostMethod method = null;
	    try {
		    HttpClient client = new HttpClient();
		    client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");//指定传送字符集为UTF-8格式
		    client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);//设置连接超时时间为30秒（连接初始化时间）
		    method = new PostMethod("http://222.73.117.158/msg/");//带参数的那个请求的访问串
		    int statusCode = client.executeMethod(method);
		    System.out.println("访问主机开始...");
		    if (statusCode != HttpStatus.SC_OK) {
		        //失败
		    }else{
		        //成功
		    }
		    System.out.println("访问主机结束.");
		    client.getHttpConnectionManager().closeIdleConnections(1);
		    System.out.println("访问主机完成.");
		}catch (Exception e) {
			System.out.println("无法访问主机");
		}finally{
		    if(method != null)
		        method.releaseConnection();
		}
	}
	//创蓝
	public void sendMsgs()throws Exception{

		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
		NameValuePair[] data ={ 
				new NameValuePair("account", account),
				new NameValuePair("pswd", pswd),
				new NameValuePair("mobile",mobile),
				new NameValuePair("msg",msg),
				new NameValuePair("needstatus", String.valueOf(needstatus))};
		
		post.setRequestBody(data);
	
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
		System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
		System.out.println(result); //打印返回消息状态
	
	
		post.releaseConnection();
	}
}
