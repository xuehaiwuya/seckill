package com.studyinghome.seckill.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MiaoshaOrder implements Serializable {
	private Long id;
	private Long userId;
	private Long  orderId;
	private Long goodsId;
}
