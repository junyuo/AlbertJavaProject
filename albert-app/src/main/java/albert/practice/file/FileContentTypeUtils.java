package albert.practice.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.tika.Tika;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileContentTypeUtils {

	private static List<String> imageMediaTypes = new ArrayList<>();

	private static void setImageMediaTypes() {
		// http://www.fileformat.info/info/mimetype/image/index.htm
		imageMediaTypes = Arrays.asList("image/cgm", "image/fits",
				"image/g3fax", "image/gif", "image/ief", "image/jp2",
				"image/jpeg", "image/jpm", "image/jpx", "image/naplps",
				"image/png", "image/prs.btif", "image/prs.pti", "image/t38",
				"image/tiff", "image/tiff-fx", "image/vnd.adobe.photoshop",
				"image/vnd.cns.inf2", "image/vnd.djvu", "image/vnd.dwg",
				"image/vnd.dxf", "image/vnd.fastbidsheet", "image/vnd.fpx",
				"image/vnd.fst", "image/vnd.fujixerox.edmics-mmr",
				"image/vnd.fujixerox.edmics-rlc",
				"image/vnd.globalgraphics.pgb", "image/vnd.microsoft.icon",
				"image/vnd.mix", "image/vnd.ms-modi", "image/vnd.net-fpx",
				"image/vnd.sealed.png", "image/vnd.sealedmedia.softseal.gif",
				"image/vnd.sealedmedia.softseal.jpg", "image/vnd.svf",
				"image/vnd.wap.wbmp", "image/vnd.xiff");
	}

	public static Boolean isImage(String sourceFile) throws IOException {
		setImageMediaTypes();
		Boolean isImage = Boolean.FALSE;
		File file = FileUtils.getFile(sourceFile);
		Tika tika = new Tika();
		try {
			String mediaType = tika.detect(file);
			isImage = imageMediaTypes.contains(mediaType);
		} catch (IOException e) {
			throw e;
		}
		return isImage;
	}

}
