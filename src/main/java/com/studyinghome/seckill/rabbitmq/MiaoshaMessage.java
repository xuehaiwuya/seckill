package com.studyinghome.seckill.rabbitmq;

import com.studyinghome.seckill.domain.MiaoshaUser;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MiaoshaMessage implements Serializable {
	private MiaoshaUser user;
	private long goodsId;
}
