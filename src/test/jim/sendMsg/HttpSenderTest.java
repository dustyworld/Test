package test.jim.sendMsg;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.bcloud.msg.http.HttpSender;

public class HttpSenderTest {
	//����sdk
	
	String url = "http://222.73.117.158/msg/HttpBatchSendSM";// Ӧ�õ�ַ
	String account = "jiekou-clcs-02";// �˺�
	String pswd = "Tch112233";// ����
	String mobile = "18996473229,15000042335";// �ֻ����룬�������ʹ��","�ָ�
	String msg = "���ã�������֤����123456";// ��������
	boolean needstatus = true;// �Ƿ���Ҫ״̬���棬��Ҫtrue������Ҫfalse
	String product = null;// ��ƷID
	String extno = null;// ��չ��
	public static void main(String[] a) throws Exception{
//		new HttpSenderTest().sendMsgs();
		new HttpSenderTest().sendMsg01();
		System.out.println("send successful");
	}
	public void sendMsg01() throws Exception{
		try {
			String returnString = HttpSender.batchSend(url, account, pswd, mobile, msg, needstatus, product, extno);
			System.out.println(returnString);
			// TODO ������ֵ,�μ�HTTPЭ���ĵ�
		} catch (Exception e) {
			// TODO �����쳣
			e.printStackTrace();
		}
	}
	public void sendMsg(){
		PostMethod method = null;
	    try {
		    HttpClient client = new HttpClient();
		    client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");//ָ�������ַ���ΪUTF-8��ʽ
		    client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);//�������ӳ�ʱʱ��Ϊ30�루���ӳ�ʼ��ʱ�䣩
		    method = new PostMethod("http://222.73.117.158/msg/");//���������Ǹ�����ķ��ʴ�
		    int statusCode = client.executeMethod(method);
		    System.out.println("����������ʼ...");
		    if (statusCode != HttpStatus.SC_OK) {
		        //ʧ��
		    }else{
		        //�ɹ�
		    }
		    System.out.println("������������.");
		    client.getHttpConnectionManager().closeIdleConnections(1);
		    System.out.println("�����������.");
		}catch (Exception e) {
			System.out.println("�޷���������");
		}finally{
		    if(method != null)
		        method.releaseConnection();
		}
	}
	//����
	public void sendMsgs()throws Exception{

		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//��ͷ�ļ�������ת��
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
		System.out.println(result); //��ӡ������Ϣ״̬
	
	
		post.releaseConnection();
	}
}
