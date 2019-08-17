package com.vcentry.tnstc.reportGenerator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class ReportOptimizer {
	public static void optimizeReport() throws IOException{
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-DD hh-mm-ss-mmm");
		String name = df.format(date);
		File src=new File("C:\\Users\\ke20\\workspace\\DDDTest\\Screenshot");
		File dst= new File("C:\\Users\\ke20\\workspace\\DDDTest\\Old Screenshot\\"+name);
		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory(src);
	}

}
