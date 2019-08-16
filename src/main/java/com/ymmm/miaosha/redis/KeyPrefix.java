package com.ymmm.miaosha.redis;

public interface KeyPrefix {
		
	int expireSeconds();
	
	String getPrefix();
	
}
