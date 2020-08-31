package com.cron.t;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class T {
	public static void main(String[] args) {
		String triggerexpr=args[0];
		String triggertm=args[1];
		CronExpression cronEx = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = null;
		boolean iss = false;
		try {
			dt = sdf.parse(triggertm);
			cronEx = new CronExpression(triggerexpr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		iss = cronEx.isSatisfiedBy(dt);
		if(iss){
			System.out.println("ok");
			System.exit(0);
		}
		System.out.println("fail");
		System.exit(1);
	}
}
