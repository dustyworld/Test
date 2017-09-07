package test.jim.email;

import java.util.Random;

public class SendEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sendCheck();
		System.out.println("send success......");
	}
	public String email;
    public static void sendCheck() {
        Random random = new Random();
        String check = "";
        for (int i = 0; i < 6; i++) {
            check += random.nextInt(10);
        }
//        Cookie cookie = new Cookie("check", check);
//        cookie.setMaxAge(3600 * 2);
//        cookie.setPath("/");
//        Object response;
//		response.addCookie(cookie);
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.qq.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("");//发送者用户名
        mailInfo.setPassword("");// 邮箱密码
        mailInfo.setFromAddress("1031780469@qq.com");//发送者邮箱，建议使用qq邮箱
        mailInfo.setToAddress("1031780469@qq.com");//接收者邮箱
        mailInfo.setSubject("Just for test");
        mailInfo.setContent("congratulation ！test successful");
        // 这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        sms.sendTextMail(mailInfo);// 发送文体格式
    }

}
