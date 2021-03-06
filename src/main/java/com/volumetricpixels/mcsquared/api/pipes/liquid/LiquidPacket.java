package com.volumetricpixels.mcsquared.api.pipes.liquid;

import com.volumetricpixels.mcsquared.api.pipes.Pipeable;

public class LiquidPacket<T extends Liquid> implements Comparable<LiquidPacket<T>>, Pipeable {

	private final float value;
	private final Class<T> liquid;

	public LiquidPacket(Class<T> liquid, float value) {
		this.liquid = liquid;
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	public Class<T> getLiquid() {
		return liquid;
	}

	public LiquidPacket<T> add(LiquidPacket<T> other) {
		return new LiquidPacket<>(other.liquid, value + other.getValue());
	}

	public LiquidPacket<T> subtract(LiquidPacket<T> other) {
		return new LiquidPacket<>(other.liquid, value - other.getValue());
	}

	public LiquidPacket<T> multiply(LiquidPacket<T> other) {
		return new LiquidPacket<>(other.liquid, value * other.getValue());
	}

	public LiquidPacket<T> divide(LiquidPacket<T> other) {
		return new LiquidPacket<>(other.liquid, value / other.getValue());
	}

	public LiquidPacket<T> split(int size) {
		return new LiquidPacket<>(liquid, value / size);
	}

	@Override
	public int compareTo(LiquidPacket<T> other) {
		if (value > other.getValue()) {
			return 1;
		}
		if (value < other.getValue()) {
			return -1;
		}
		return 0;
	}

	public static <U extends Liquid> LiquidPacket<U> getEmpty(Class<U> l) {
		return new LiquidPacket<>(l, 0f);
	}
}