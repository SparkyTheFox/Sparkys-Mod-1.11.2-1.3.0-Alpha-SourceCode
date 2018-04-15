package mod.sparkyfox.servermod.entity;

import com.google.gson.annotations.SerializedName;

import mod.sparkyfox.servermod.item.ItemAmmo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public class Gun
{
	public String id;
	public Projectile projectile;
	public Sounds sounds;
	public Display display;
	
	public static class Projectile implements INBTSerializable<NBTTagCompound>
	{
		public ItemAmmo.Type type;
		public boolean visible;
		public boolean auto;
		public int rate;
		public float damage;
		public float size;
		public double speed;
		public int life;
		public boolean gravity;
		public boolean damageReduceOverLife;
		public boolean damageReduceIfNotZoomed;

		@Override
		public NBTTagCompound serializeNBT() 
		{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("type", this.type.ordinal());
			tag.setBoolean("visible", this.visible);
			tag.setFloat("damage", this.damage);
			tag.setFloat("size", this.size);
			tag.setDouble("speed", this.speed);
			tag.setInteger("life", this.life);
			tag.setBoolean("gravity", this.gravity);
			tag.setBoolean("damageReduceOverLife", this.damageReduceOverLife);
			tag.setBoolean("damageReduceIfNotZoomed", this.damageReduceIfNotZoomed);
			return tag;
		}

		@Override
		public void deserializeNBT(NBTTagCompound tag) 
		{
			this.type = ItemAmmo.Type.values()[tag.getInteger("type")];
			this.visible = tag.getBoolean("visible");
			this.damage = tag.getFloat("damage");
			this.size = tag.getFloat("size");
			this.speed = tag.getDouble("speed");
			this.life = tag.getInteger("life");
			this.gravity = tag.getBoolean("gravity");
			this.damageReduceOverLife = tag.getBoolean("damageReduceOverLife");
			this.damageReduceIfNotZoomed = tag.getBoolean("damageReduceIfNotZoomed");
		}
	}
	
	public static class Sounds
	{
		public String fire;
		public String reload;
		public String cock;
	}
	
	public static class Display
	{
		public boolean canZoom;
		public float zoomFovModifier;
		public double zoomXOffset;
		public double zoomYOffset;
		public double zoomZOffset;
		public boolean zoomSmooth;
		public double flashXOffset;
		public double flashYOffset;
		public double flashZOffset;
		public double scopeXOffset;
		public double scopeYOffset;
		public double scopeZOffset;
	}
}
