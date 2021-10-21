package com.xiongping.service.lottory;

import com.xiongping.service.lottory.anno.TimeLottery;
import org.springframework.stereotype.Component;

@Component
@TimeLottery
public class TimeLotteryStrategy implements Lottery {

	@Override
	public String strategyName() {
		return "timeLotteryStrategy";
	}
}
