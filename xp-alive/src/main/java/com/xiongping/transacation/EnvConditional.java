package com.xiongping.transacation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author xiongping
 * @version 1.0
 * @since 2024/9/13
 **/
public class EnvConditional implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String annoName = Activity.class.getName();
		boolean markedActivity = metadata.isAnnotated(annoName);
		if (markedActivity) {
			Map<String, Object> activityAttributes = metadata.getAnnotationAttributes(annoName);
			assert activityAttributes != null;
			return (Boolean) activityAttributes.get("value");
		} else {
			return true;
		}
	}
}
