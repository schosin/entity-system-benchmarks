package com.artemis.system;


import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.component.PlainPosition;
import com.artemis.systems.EntityProcessingSystem;
import org.openjdk.jmh.infra.Blackhole;

@Wire
public class PlainPositionSystem extends EntityProcessingSystem {

	ComponentMapper<PlainPosition> positionMapper;

	Blackhole voidness = new Blackhole();
	
	
	@SuppressWarnings("unchecked")
	public PlainPositionSystem() {
		super(Aspect.all(PlainPosition.class));
	}

	@Override
	protected void process(Entity e) {
		PlainPosition pos = positionMapper.get(e);
		pos.x += 1;
		pos.y -= 1;
		
		voidness.consume(e);
	}
}
