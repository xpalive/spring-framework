package com.xiongping.service.lottory;

import com.xiongping.service.lottory.anno.RandomLottery;
import org.springframework.stereotype.Component;

@Component
@RandomLottery
public class RandomLotteryStrategy implements Lottery {

	@Override
	public String strategyName() {
		return "randomLotteryStrategy";
	}
}
