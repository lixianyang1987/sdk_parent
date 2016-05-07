package com.hytx.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hytx.model.system.User;

public class ListUtil {

	/****
	 * 将list中的对象提取某两个属性映射成map
	 * 
	 * @param list
	 * @param keyName
	 * @param valueName
	 * @return
	 * @author houzz
	 * @date 2015年5月18日
	 * 
	 */
	public static <T> Map<Object, Object> changeListToMap(List<T> list,
			String keyName, String valueName) {
		if (list == null) {
			return null;
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {
			Class<? extends Object> clazz = list.get(0).getClass();
			PropertyDescriptor propDescKey = new PropertyDescriptor(keyName,
					clazz);
			Method keyReadMethod = propDescKey.getReadMethod();
			PropertyDescriptor propDescValue = new PropertyDescriptor(
					valueName, clazz);
			Method valueReadMethod = propDescValue.getReadMethod();
			for (T obj : list) {
				Object key = keyReadMethod.invoke(obj, new Object[] {});
				Object value = valueReadMethod.invoke(obj, new Object[] {});
				if (key != null) {
					map.put(key, value);
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		String[] names = new String[] { "aaa", "bbb", "ccc", "ddd", "eee",
				"fff" };
		for (int i = 0; i < 6; i++) {
			User user = new User();
			user.setId(i);
			user.setUserName(names[i]);
			userList.add(user);
		}
		Map<Object, Object> map = changeListToMap(userList, "id", "userName");
		for (Entry<Object, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println(map.get(3));
	}
}
