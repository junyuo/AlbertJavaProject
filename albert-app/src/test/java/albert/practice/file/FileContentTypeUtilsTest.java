package albert.practice.file;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileContentTypeUtilsTest extends FileContentTypeUtils {

	private String imageFile;
	private String pdfFile;

	@Before
	public void setup() {
		imageFile = "/Users/albert/Dropbox/picture/panda.png";
		pdfFile = "/Users/albert/Dropbox/test_測試.pdf";
	}

	@Test
	public void testImageFile() throws IOException {
		Assert.assertTrue(isImage(imageFile));
	}

	@Test
	public void testPdfFile() throws IOException {
		Assert.assertFalse(isImage(pdfFile));
	}

}
