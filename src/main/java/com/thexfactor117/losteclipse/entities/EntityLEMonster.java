package com.thexfactor117.losteclipse.entities;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EntityLEMonster extends EntityMob
{
	public EntityLEMonster(World world) 
	{
		super(world);
		this.clearAITasks();
	}
	
	/**
	 * Removes all previous AI tasks. Creates a blank state to build other AI's upon.
	 */
	protected void clearAITasks()
	{
		tasks.taskEntries.clear();
		targetTasks.taskEntries.clear();
	}
}
