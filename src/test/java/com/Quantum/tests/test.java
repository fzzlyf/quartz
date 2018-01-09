package com.Quantum.tests;

import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.impl.StdScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Quantum.job.HelloWorldJob;
import com.Quantum.service.QuartzService;

public class test {

	private static Scheduler scheduler;
	@Test
	public void addJob() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-quartz.xml","classpath:spring-servlet.xml"});
		QuartzService quartzService = (QuartzService) ac.getBean("quartzService");
		quartzService.addJob("job1_1", "jGroup1", "trigger1_1", "tGroup1", HelloWorldJob.class, "0/2 * * * * ?");
	
	}
	
	@Test
	public void start() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-quartz.xml","classpath:spring-servlet.xml"});
		QuartzService quartzService = (QuartzService) ac.getBean("quartzService");
		quartzService.startSchedule();
	
	}
}
