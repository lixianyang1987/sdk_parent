package com.hytx.web.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.service.client.ISyncEnsureStatusService;

@Controller
@RequestMapping("/client")
public class SyncEnsureStatusController {
	private static final Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	@Qualifier("syncEnsureStatusServiceImpl")
	private ISyncEnsureStatusService syncEnsureStatusService;

	@RequestMapping(value = "syncEnsureStatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String syncEnsureStatus(@RequestBody String content) {
		logger.info("二次确认同步状态数据：{}", content);
		if (StringUtils.isBlank(content)) {
			return "failure";
		}
		JSONObject dataJson = JSONObject.fromObject(content);
		if (dataJson == null) {
			return "failure";
		}
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		Iterator<String> keys = dataJson.keys();
		while (keys.hasNext()) {
			String commandIdStr = keys.next();
			map.put(Long.parseLong(commandIdStr), dataJson.getInt(commandIdStr));
		}
		if (!map.isEmpty()) {
			syncEnsureStatusService.updateReqSmsCommandStatus(map);
		}
		return "ok";
	}

	@RequestMapping(value = "syncLayoutStatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String syncLayoutStatus(@RequestBody String orderId) {
		logger.info("短信状态拦截同步数据：{}", orderId);
		if (StringUtils.isBlank(orderId)) {
			return "failure";
		}
		syncEnsureStatusService.updateReqSmsLayoutStatus(orderId);
		return "ok";
	}

	@RequestMapping(value = "syncClickStatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String syncClickStatus(@RequestBody String content) {
		logger.info("用户点击行为同步数据：{}", content);
		if (StringUtils.isBlank(content)) {
			return "failure";
		}
		String[] arr = content.split(":");
		if (arr.length == 2) {
			syncEnsureStatusService.updateReqSmsExTraInfo(arr[0], arr[1]);
			return "ok";
		}
		return "failure";
	}

}
