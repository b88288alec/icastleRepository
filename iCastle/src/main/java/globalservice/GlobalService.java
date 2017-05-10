package globalservice;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.binary.Base64;

public class GlobalService {
	
	public Boolean SendGmail(String to, String subject, String content){
		String host = "smtp.gmail.com";
		int port = 587;
		
		//寄信者
		final String username = "eeitteam01@gmail.com";
		final String password = "h12456789";
		
		//收信者
//		final String to = "eeit93no1@gmail.com";

		//信件標題和內容
//		final String subject = "忘記密碼";
//		final String content = 
//				"您的新密碼為<br>"
//				+ "<a href='http://localhost:8081/iCastle/index.jsp'></a>";
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("iCastle@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject, "UTF-8");
			
			message.setContent(content, "text/html; charset=UTF-8");

			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);

			Transport.send(message);

			System.out.println("Email寄送成功");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		return true;
	}

	public static void main(String[] args){
		byte[] bytes2 = Base64.decodeBase64("DFSDFDSFFD");
		System.out.println(bytes2.length);
		
		
		for (byte b : bytes2)
			System.out.println(b);
	}
}
