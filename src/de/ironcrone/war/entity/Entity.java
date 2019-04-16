package de.ironcrone.war.entity;

import java.awt.Graphics;

import de.ironcrone.war.utility.XY;

public abstract class Entity {

	protected XY xy;
	protected EntityType entityType;
	protected final int ID;
	public static int nextID = 1;

	public Entity(XY xy) {
		
		this.xy = xy;
		ID = nextID;
		nextID++;
		
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

	public XY getXy() {
		return xy;
	}

	public void setXy(XY xy) {
		this.xy = xy;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public int getID() {
		return ID;
	}
	
}
