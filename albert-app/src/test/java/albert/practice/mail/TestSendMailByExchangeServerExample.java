package albert.practice.mail;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.velocity.VelocityEngineUtils;

import lombok.extern.slf4j.Slf4j;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@Slf4j
public class TestSendMailByExchangeServerExample {

    private SendMailByExchangeServerExample.EmailParams params = null;
    private SendMailByExchangeServerExample.Customer customer = null;
    private SendMailByExchangeServerExample sendMailService;

    @Before
    public void setup() {
        params = new SendMailByExchangeServerExample.EmailParams();
        params.setSender("test@cht.com.tw");
        params.setReceiver("test@cht.com.tw");
        params.setSubject("電子郵件測試 (Email test)");
        params.setAttachments(Arrays.asList(new File("D:/dropbox/test_測試.pdf"),
                new File("D:/dropbox/Getting Started.pdf")));
        Map<String, String> imgMap = new HashMap<>();
        imgMap.put("Chansey", "img/Chansey.png");
        imgMap.put("Hitmonchan", "img/Hitmonchan.png");
        imgMap.put("Pikachu", "img/Pikachu.png");
        params.setImgMap(imgMap);

        customer = new SendMailByExchangeServerExample.Customer();
        customer.setPolicyNumber("12345678");
        customer.setName("測試");
        customer.setApplyDate("20170201");
        customer.setFromDate("20170228");
        customer.setToDate("20160410");
        customer.setPlace("日本關西");

        sendMailService = new SendMailByExchangeServerExample();
    }

    @Test
    public void testSendMail() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        VelocityEngine velocityEngine = (VelocityEngine) context.getBean("velocityEngine");

        // set customer to map for velocity email template
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("customer", customer);

        // get email content from velocity email template
        String mailTemplate = "albert/practice/mail/template/template.vm";
        String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, mailTemplate,
                "UTF-8", model);
        log.debug("content=" + content);
        params.setContent(content);

        sendMailService.sendMail(params);
    }

    @Test
    public void testEmailParamsBean() {
        new BeanTester().testBean(SendMailByExchangeServerExample.EmailParams.class);
    }

    @Test
    public void testCustomerBean() {
        new BeanTester().testBean(SendMailByExchangeServerExample.Customer.class);
    }

    @Test
    public void testEmailParamsBeanEqualsAndHashcode() {
        EqualsVerifier.forClass(SendMailByExchangeServerExample.EmailParams.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
    
    @Test
    public void testCustomerBeanEqualsAndHashcode() {
        EqualsVerifier.forClass(SendMailByExchangeServerExample.Customer.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
}
