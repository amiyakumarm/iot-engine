package com.iotengine.core;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iotengine.dto.RawItemInsight;
import com.iotengine.util.TimeStampUtil;

/**
 * 
 * @author amiyakumar.m
 *
 */
@Service
public class EngineCore {

	EngineCore() {

	}

	/**
	 * @throws Throwable
	 */
	public void init() throws Throwable {

	}

	/**
	 * 
	 * @param rawInput
	 *                        <p>
	 *                        sorted in order
	 *                        </p>
	 * @param minDiffDuration
	 * @throws Throwable
	 */
	public List<String> doProcess(List<RawItemInsight> rawInput, int minDiffDuration) throws Throwable {

		if (null == rawInput || rawInput.isEmpty())
			throw new Exception("Raw data is empty!");

		List<String> missedTimeSlots = new LinkedList<>();

		// Find the diff by comparing adjacent
		for (int i = 1; i < rawInput.size(); i++) {
			RawItemInsight prev = rawInput.get(i - 1);
			RawItemInsight current = rawInput.get(i);
			long timeDiff = TimeStampUtil.timestampDiff(current.getTimestamp(), prev.getTimestamp());

			if (timeDiff > minDiffDuration)
				for (int j = 0; j < timeDiff - 1; j++) {

					missedTimeSlots.add(TimeStampUtil.increment(prev.getTimestamp(), minDiffDuration + j));
				}
		}
		return missedTimeSlots;
	}
}
