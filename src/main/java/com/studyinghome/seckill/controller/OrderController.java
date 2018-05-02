package com.studyinghome.seckill.controller;

import com.studyinghome.seckill.domain.MiaoshaUser;
import com.studyinghome.seckill.domain.OrderInfo;
import com.studyinghome.seckill.redis.RedisService;
import com.studyinghome.seckill.result.CodeMsg;
import com.studyinghome.seckill.result.Result;
import com.studyinghome.seckill.service.GoodsService;
import com.studyinghome.seckill.service.MiaoshaUserService;
import com.studyinghome.seckill.service.OrderService;
import com.studyinghome.seckill.vo.GoodsVo;
import com.studyinghome.seckill.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    public Result<OrderDetailVo> info(Model model, MiaoshaUser user,
                                      @RequestParam("orderId") long orderId) {
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
