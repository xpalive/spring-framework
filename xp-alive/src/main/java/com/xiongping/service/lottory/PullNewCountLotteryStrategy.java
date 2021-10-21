package com.xiongping.service.lottory;

import com.xiongping.service.lottory.anno.PullNewCountLottery;
import org.springframework.stereotype.Component;

@Component
@PullNewCountLottery
public class PullNewCountLotteryStrategy implements Lottery {

	@Override
	public String strategyName() {
		return "pullNewCountLottery";
	}
}
