package com.kedu.Scheduler;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {

	@Scheduled(cron="*/5 * * * * ?")
	public void test() {
		//
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		System.out.println(sdf.format(System.currentTimeMillis()));
	}
}
