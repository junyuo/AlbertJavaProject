package albert.practice.io;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AgeFilter {

	/**
	 * 找出某個日期以前的檔案.
	 * 
	 * @param directory 找出某個目錄下的檔案
	 * @param date 日期條件
	 * @param includeSubdir 是否包含子目錄 (true / false)
	 * @return List of File
	 */
	public List<File> listFiles(String directory, Date date, Boolean includeSubdir) {
		IOFileFilter ageFileFilter = FileFilterUtils.ageFileFilter(date);
		IOFileFilter subDirFilter = includeSubdir ? FileFilterUtils.trueFileFilter()
				: FileFilterUtils.falseFileFilter();
		Collection<File> fileCollection = FileUtils.listFiles(new File(directory), ageFileFilter, subDirFilter);
		return new ArrayList<>(fileCollection);
	}

	public static void main(String[] args) throws IOException {
		String directory = "D:/work/集保/DP/SQL/dp";
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -65);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		Date myDate = cal.getTime();
		log.info("myDate = " + toDateString(myDate));
		
		List<File> files = new AgeFilter().listFiles(directory, myDate, true);
		log.info("size of file : " + files.size());
		for(File file : files){
			log.info(file.getCanonicalPath());
		}
		
		String pp7 = "二、董監選舉結果:" + "\r\n";
		System.out.println(pp7);
	}
	
	private static String toDateString(Date date){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		return dateFormat.format(date);
	}
}
