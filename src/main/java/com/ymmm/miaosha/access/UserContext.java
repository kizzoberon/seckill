package com.ymmm.miaosha.access;

import com.ymmm.miaosha.domain.MiaoshaUser;

public class UserContext {
	
	private static ThreadLocal<MiaoshaUser> userHolder = new ThreadLocal<>();
	
	public static void setUser(MiaoshaUser user) {
		userHolder.set(user);
	}
	
	public static MiaoshaUser getUser() {
		return userHolder.get();
	}

	public static void removeUser() {
		userHolder.remove();
	}

}
