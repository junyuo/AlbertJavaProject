package albert.practice.mail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendMailExample {

    public void sendMail(EmailParams params) {
        JavaMailSenderImpl sender = getJavaMailSender();
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(params.getReceiver());
            helper.setFrom(params.getSender());
            helper.setSubject(params.getSubject());
            helper.setText(params.getContent(), true);

            // add attachment if any
            List<File> attachments = params.getAttachments();
            if (CollectionUtils.isNotEmpty(attachments)) {
                for (File file : attachments) {
                    helper.addAttachment(file.getName(), file);
                }
            }

            // add image if any
            if(CollectionUtils.isNotEmpty(params.getImgs())) {
                for(ImgParams img : params.getImgs()) {
                    InputStreamSource logo = new ByteArrayResource(
                            IOUtils.toByteArray(img.getFileInputStream()));
                    helper.addInline(img.getFileName(), logo, img.getContentType().getContentType());
                }
            }
//            if (params.getImgs() != null) {
//                for (Map.Entry<String, InputStream> entry : params.getImgs().entrySet()) {
//                    InputStreamSource logo = new ByteArrayResource(
//                            IOUtils.toByteArray(entry.getValue()));
//                    helper.addInline(entry.getKey(), logo, "image/png");
//                }
//            }

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        sender.setDefaultEncoding("UTF-8");
        sender.send(message);
    }

    private JavaMailSenderImpl getJavaMailSender() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.ssl.trust", "*");

        // mail server configuration
        String host = "email.cht.com.tw";
        int port = 25;
        String userName = "test";
        String password = "test";

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setJavaMailProperties(props);
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(userName);
        sender.setPassword(password);
        sender.setDefaultEncoding("UTF-8");

        return sender;
    }
    
    private JavaMailSenderImpl getGmailSender(){
    	 Properties props = new Properties();
    	 props.put("mail.smtp.starttls.enable", "true");

         // mail server configuration
         String host = "smtp.gmail.com";
         int port = 587;
         String userName = "junyuo";
         String password = "test";

         JavaMailSenderImpl sender = new JavaMailSenderImpl();
         sender.setJavaMailProperties(props);
         sender.setHost(host);
         sender.setPort(port);
         sender.setUsername(userName);
         sender.setPassword(password);
         sender.setDefaultEncoding("UTF-8");

         return sender;
    }

    @Data
    public static class EmailParams {
        private String sender;
        private String receiver;
        private String subject;
        private String content;
        private List<File> attachments;
        private List<ImgParams> imgs;
    }
    
    @Data
    public static class ImgParams {
        private String fileName;
        private InputStream fileInputStream;
        private ContentTypeEnum contentType;
    }

    @Data
    public static class Customer {
        private String policyNumber;
        private String name;
        private String applyDate;
        private String fromDate;
        private String toDate;
        private String place;
    }

}
