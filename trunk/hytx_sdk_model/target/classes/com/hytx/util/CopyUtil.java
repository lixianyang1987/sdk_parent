package com.hytx.util;

import java.util.Date;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

import com.hytx.model.system.Role;
import com.hytx.model.system.User;

public class CopyUtil {
	/****
	 * 对象拷贝
	 * 
	 * @param source
	 * @param target
	 */
	public static void copy(Object source, Object target) {
		BeanCopier copier = BeanCopier.create(source.getClass(),
				target.getClass(), false);
		copier.copy(source, target, null);
	}

	/***
	 * 对象拷贝
	 * 
	 * @param source
	 * @param target
	 * @param converter
	 */
	public static void copy(Object source, Object target, Converter converter) {
		if (converter == null) {
			copy(source, target);
		} else {

			BeanCopier copier = BeanCopier.create(source.getClass(),
					target.getClass(), true);
			copier.copy(source, target, converter);
		}
	}

	public static void main(String[] args) {
		User user = new User();
		user.setId(123);
		user.setCreateDt(new Date());
		Role role = new Role();
		copy(user, role);
		System.out.println(role.getCreateDt());

	}

}
