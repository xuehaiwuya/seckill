package com.studyinghome.seckill.vo;

import com.studyinghome.seckill.domain.MiaoshaUser;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GoodsDetailVo implements Serializable {
    private int miaoshaStatus = 0;
    private int remainSeconds = 0;
    private GoodsVo goods;
    private MiaoshaUser user;
}
