package com.artemis.system;


import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.component.PooledPosition;
import com.artemis.systems.EntityProcessingSystem;
import org.openjdk.jmh.infra.Blackhole;

@Wire
public class PooledPositionSystem extends EntityProcessingSystem {

	Blackhole voidness = new Blackhole();
	ComponentMapper<PooledPosition> positionMapper;
	
	@SuppressWarnings("unchecked")
	public PooledPositionSystem() {
		super(Aspect.all(PooledPosition.class));
	}

	@Override
	protected void process(Entity e) {
		PooledPosition pos = positionMapper.get(e);
		pos.x += 1;
		pos.y -= 1;
		
		voidness.consume(e);
	}
}
