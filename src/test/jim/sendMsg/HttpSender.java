package test.jim.sendMsg;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * @author Beyond
 */
public class HttpSender {

	/**
	 * 
	 * @param uri Ӧ�õ�ַ��������http://ip:port/msg/
	 * @param account �˺�
	 * @param pswd ����
	 * @param mobiles �ֻ����룬�������ʹ��","�ָ�
	 * @param content ��������
	 * @param needstatus �Ƿ���Ҫ״̬���棬��Ҫtrue������Ҫfalse
	 * @return ����ֵ����μ�HTTPЭ���ĵ�
	 * @throws Exception
	 */
	public static String send(String uri, String account, String pswd, String mobiles, String content,
			boolean needstatus, String product, String extno) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod();
		try {
			URI base = new URI(uri, false);
			method.setURI(new URI(base, "HttpSendSM", false));
			method.setQueryString(new NameValuePair[] { 
					new NameValuePair("account", account),
					new NameValuePair("pswd", pswd), 
					new NameValuePair("mobile", mobiles),
					new NameValuePair("needstatus", String.valueOf(needstatus)), 
					new NameValuePair("msg", content),
					new NameValuePair("product", product), 
					new NameValuePair("extno", extno), 
				});
			int result = client.executeMethod(method);
			if (result == HttpStatus.SC_OK) {
				InputStream in = method.getResponseBodyAsStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				return URLDecoder.decode(baos.toString(), "UTF-8");
			} else {
				throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
			}
		} finally {
			method.releaseConnection();
		}

	}

	/**
	 * 
	 * @param uri Ӧ�õ�ַ��������http://ip:port/msg/
	 * @param account �˺�
	 * @param pswd ����
	 * @param mobiles �ֻ����룬�������ʹ��","�ָ�
	 * @param content ��������
	 * @param needstatus �Ƿ���Ҫ״̬���棬��Ҫtrue������Ҫfalse
	 * @return ����ֵ����μ�HTTPЭ���ĵ�
	 * @throws Exception
	 */
	public static String batchSend(String uri, String account, String pswd, String mobiles, String content,
			boolean needstatus, String product, String extno) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod();
		try {
			URI base = new URI(uri, false);
			method.setURI(new URI(base, "HttpBatchSendSM", false));
			method.setQueryString(new NameValuePair[] { 
					new NameValuePair("account", account),
					new NameValuePair("pswd", pswd), 
					new NameValuePair("mobile", mobiles),
					new NameValuePair("needstatus", String.valueOf(needstatus)), 
					new NameValuePair("msg", content),
					new NameValuePair("product", product),
					new NameValuePair("extno", extno), 
				});
			int result = client.executeMethod(method);
			if (result == HttpStatus.SC_OK) {
				InputStream in = method.getResponseBodyAsStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				return URLDecoder.decode(baos.toString(), "UTF-8");
			} else {
				throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
			}
		} finally {
			method.releaseConnection();
		}

	}
}