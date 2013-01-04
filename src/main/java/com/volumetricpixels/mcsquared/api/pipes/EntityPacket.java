package com.volumetricpixels.mcsquared.api.pipes;

import org.spout.api.entity.Entity;

public class EntityPacket<T extends Entity> implements Pipeable {
	
	private final Class<T> entity;
	
	public EntityPacket(Class<T> entity) {
		this.entity = entity;
	}
	
	public Class<T> getEntity() {
		return entity;
	}

}
