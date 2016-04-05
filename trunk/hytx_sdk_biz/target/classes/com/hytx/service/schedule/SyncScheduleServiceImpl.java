package com.hytx.service.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/******
 * 
 * 一个cron表达式有到少6个(也可能是7个)由空格分隔的时间元素.从左到右,这些元素的定义如下: 1.秒(0-59) 2.分钟(0-59)
 * 3.小时(0-23) 4.月份中的是期(1-31) 5.月份(1-12或SUN-DEC) 6.星期中的日期(1-7或SUN-SAT)
 * 7.年份(1970-2099) 例子: 0 0 10,14,16 * * ? 每天上午10点,下午2点和下午4点 0 0,15,30,45 * 1-10
 * * ? 每月前10天每隔15分钟 30 0 0 1 1 ? 2012 在2012年1月1日午夜过30秒时 0 0 8-5 ? * MON-FRI
 * 每个工作日的工作时间 - 区间 通配符 ? 你不想设置那个字段
 * 
 * @author houzz
 *
 */
@Service("syncScheduleServiceImpl")
public class SyncScheduleServiceImpl implements ISyncScheduleService {

	/****
	 * 每隔半小时执行一次
	 */
	@Override
	@Scheduled(cron = "* 0/30 * * * ?")
	public void execute() {
		// System.out.println("定时执行:" + System.currentTimeMillis() / 1000);
	}

}
