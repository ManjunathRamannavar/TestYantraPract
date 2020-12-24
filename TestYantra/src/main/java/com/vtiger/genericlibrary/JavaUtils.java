package com.vtiger.genericlibrary;

import java.util.Date;
import java.util.Random;
/**
 *   This class contains java specific libarraies , which include getSystemData , getRanNumber etc
 * @author Deepak
 *
 */
public class JavaUtils {
	
	/**
	 * used to get the random number range of 1 to 10000
	 * @return
	 */
	public static int getRanDomData() {
		Random random = new Random();
		int  randomData = random.nextInt(10000);
		return randomData;
	}
	/**
	 * used the get the system current data with time
	 * @return
	 */
	public static Date getSystemDate() {
		Date date = new Date();
		return date;
	}

}
