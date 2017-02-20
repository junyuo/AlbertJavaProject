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

import com.google.common.base.Strings;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
            if (CollectionUtils.isNotEmpty(params.getImgs())) {
                for (EmailImgParams img : params.getImgs()) {
                    InputStreamSource logo = new ByteArrayResource(
                            IOUtils.toByteArray(img.getFileInputStream()));
                    helper.addInline(img.getFileName(), logo,
                            img.getContentType().getContentType());
                }
            }

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

    private JavaMailSenderImpl getGmailSender() {
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
        private List<EmailImgParams> imgs;
    }

    @NoArgsConstructor
    public static class EmailImgParams {
        @Getter @Setter private String fileName;
        @Getter @Setter private InputStream fileInputStream;
        @Getter @Setter private ContentTypeEnum contentType;
        
        private EmailImgParams(EmailImgParamBuilder builder) {
            this.fileName = builder.fileName;
            this.fileInputStream = builder.fileInputStream;
            this.contentType = builder.contentType;
        }

        public static class EmailImgParamBuilder {
            private String fileName;
            private InputStream fileInputStream;
            private ContentTypeEnum contentType;

            public EmailImgParamBuilder fileName(String fileName) {
                this.fileName = fileName;
                return this;
            }

            public EmailImgParamBuilder fileInputStream(InputStream fileInputStream) {
                this.fileInputStream = fileInputStream;
                return this;
            }

            public EmailImgParamBuilder contentType(ContentTypeEnum contentType) {
                this.contentType = contentType;
                return this;
            }
            
            public EmailImgParams build() {
                EmailImgParams emailImgParams = new EmailImgParams(this);
                if(Strings.isNullOrEmpty(emailImgParams.getFileName())) {
                    throw new RuntimeException("file name cannot be null !");
                }
                
                if(emailImgParams.getFileInputStream() == null) {
                    throw new RuntimeException("file inputStream cannot be null !");
                }
                
                if(emailImgParams.getContentType() == null) {
                    throw new RuntimeException("content type cannot be null !");
                }
                return emailImgParams;
            }
        }
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
