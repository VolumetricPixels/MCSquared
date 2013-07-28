package com.volumetricpixels.mcsquared.api.energy;

public interface Energy<T extends Energy<?>> extends Comparable<T> {

	public T add(T other);

	public T subtract(T other);

	public T multiply(T other);

	public T divide(T other);

	public T split(int size);

	public T newEmpty();

	public boolean isEmpty();
}