package com.volumetricpixels.mcsquared.api.energy.electricity;

import com.volumetricpixels.mcsquared.api.energy.Energy;

public class Electricity implements Energy<Electricity> {

	public static final Electricity EMPTY = new Electricity(0.0f);
	private final float energy;

	public Electricity(float energy) {
		if (energy < 0) {
			throw new IllegalArgumentException("Energy cannot be negative!");
		}
		this.energy = energy;
	}

	public float getValue() {
		return energy;
	}

	@Override
	public Electricity add(Electricity other) {
		return new Electricity(energy + other.energy);
	}

	@Override
	public Electricity subtract(Electricity other) {
		return new Electricity(energy - other.energy);
	}

	@Override
	public Electricity multiply(Electricity other) {
		return new Electricity(energy * other.energy);
	}

	@Override
	public Electricity divide(Electricity other) {
		return new Electricity(energy / other.energy);
	}

	@Override
	public Electricity split(int size) {
		return new Electricity(energy / size);
	}

	@Override
	public Electricity newEmpty() {
		return Electricity.EMPTY;
	}

	@Override
	public boolean isEmpty() {
		return energy == 0;
	}

	@Override
	public int compareTo(Electricity other) {
		return energy == other.energy ? 0 : (energy - other.energy > 0 ? 1 : -1);
	}
}