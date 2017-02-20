package albert.practice.mail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.velocity.VelocityEngineUtils;

import albert.practice.mail.SendMailExample.ImgParams;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestSendMailExample {

	private SendMailExample.EmailParams params = null;
	private SendMailExample.Customer customer = null;
	private SendMailExample sendMailService;

	@Before
	public void setup() throws IOException {
		
		String imgPath = "C:/Users/albert/Desktop/picpick/";
		
		params = new SendMailExample.EmailParams();
		params.setSender("test@cht.com.tw");
		params.setReceiver("test@cht.com.tw");
		params.setSubject("電子郵件測試 (Email test)");
		params.setAttachments(
				Arrays.asList(new File("D:/dropbox/test_測試.pdf"),
						new File("D:/dropbox/Getting Started.pdf")));
		
		SendMailExample.ImgParams chansey = new ImgParams();
		chansey.setFileName("Chansey");
		chansey.setFileInputStream(FileUtils.openInputStream(new File(imgPath+"Chansey.png")));
		chansey.setContentType(ContentTypeEnum.PNG);
		
		SendMailExample.ImgParams panda = new ImgParams();
		panda.setFileName("Panda");
		panda.setFileInputStream(FileUtils.openInputStream(new File(imgPath+"0.panda2.png")));
        panda.setContentType(ContentTypeEnum.PNG);
		
		params.setImgs(Arrays.asList(chansey, panda));
		
		customer = new SendMailExample.Customer();
		customer.setPolicyNumber("12345678");
		customer.setName("陳小明");
		customer.setApplyDate("20170201");
		customer.setFromDate("20170228");
		customer.setToDate("20160410");
		customer.setPlace("日本關西");

		sendMailService = new SendMailExample();
	}

	@Test
	public void testSendMail() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-beans.xml");
		VelocityEngine velocityEngine = (VelocityEngine) context
				.getBean("velocityEngine");

		// set customer to map for velocity email template
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer", customer);

		// get email content from velocity email template
		String mailTemplate = "albert/practice/mail/template/template.vm";
		String content = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, mailTemplate, "UTF-8", model);
		params.setContent(content);

		sendMailService.sendMail(params);
	}

	@Test
	public void testEmailParamsBean() {
		new BeanTester()
				.testBean(SendMailExample.EmailParams.class);
	}
	
	@Test
	public void testImgParamsBean() {
	    new BeanTester().testBean(SendMailExample.ImgParams.class);
	}

	@Test
	public void testCustomerBean() {
		new BeanTester()
				.testBean(SendMailExample.Customer.class);
	}

	@Test
	public void testImgParamsBeanEqualsAndHashcode() {
		EqualsVerifier
				.forClass(SendMailExample.ImgParams.class)
				.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
				.verify();
	}
	
	@Test
    public void testEmailParamsBeanEqualsAndHashcode() {
        EqualsVerifier
                .forClass(SendMailExample.EmailParams.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .verify();
    }

	@Test
	public void testCustomerBeanEqualsAndHashcode() {
		EqualsVerifier.forClass(SendMailExample.Customer.class)
				.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
				.verify();
	}
}
