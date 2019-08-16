package com.ymmm.miaosha.controller;

import com.ymmm.miaosha.domain.MiaoshaUser;
import com.ymmm.miaosha.domain.OrderInfo;
import com.ymmm.miaosha.redis.RedisService;
import com.ymmm.miaosha.result.CodeMsg;
import com.ymmm.miaosha.result.Result;
import com.ymmm.miaosha.service.GoodsService;
import com.ymmm.miaosha.service.MiaoshaUserService;
import com.ymmm.miaosha.service.OrderService;
import com.ymmm.miaosha.vo.GoodsVo;
import com.ymmm.miaosha.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
    MiaoshaUserService userService;
	
	@Autowired
    RedisService redisService;
	
	@Autowired
    OrderService orderService;
	
	@Autowired
    GoodsService goodsService;
	
    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(MiaoshaUser user, @RequestParam("orderId") long orderId) {
    	if(user == null) {
    		return Result.error(CodeMsg.SESSION_ERROR);
    	}
    	OrderInfo order = orderService.getOrderById(orderId);
    	if(order == null) {
    		return Result.error(CodeMsg.ORDER_NOT_EXIST);
    	}
    	long goodsId = order.getGoodsId();
    	GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
    	OrderDetailVo vo = new OrderDetailVo();
    	vo.setOrder(order);
    	vo.setGoods(goods);
    	return Result.success(vo);
    }
    
}
