package com.trello.qspiders.genericutility;

import java.time.LocalDateTime;

/**
 * This Class contains Java accessories which will facilitate in building.
 * 
 * automation Script 
 * @author AJAY BOSS
 *
 */
public class JavaUtility 
{
	/**
	 * This method will provide the unique file name for the screen Shot which ever we taken.
	 * 
	 * @author QASM6
	 * @return
	 */
	public String timeStamp()
	{
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		return timeStamp;
	}
}
