package com.Ibm.utility;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "D:/E_CART/Online_shopping/src/main/webapp/assests/images/";
	private static String REAL_PATH = "";
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assests/images/");
		logger.error(REAL_PATH);
		logger.debug(REAL_PATH);
			System.out.println("real path is:"+REAL_PATH);
			System.out.println("absolute path is:"+ABS_PATH);
		
		if (!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();

		}
		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();

		}

		try {
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			file.transferTo(new File(ABS_PATH + code + ".jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
