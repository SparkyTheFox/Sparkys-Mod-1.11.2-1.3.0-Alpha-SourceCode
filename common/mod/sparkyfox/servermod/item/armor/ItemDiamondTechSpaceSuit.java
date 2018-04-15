package mod.sparkyfox.servermod.item.armor;

import mod.sparkyfox.servermod.ServerMod;
import mod.sparkyfox.servermod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemDiamondTechSpaceSuit extends ItemArmor {

	public ItemDiamondTechSpaceSuit(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, 0, equipmentSlotIn);
	    this.setCreativeTab(null);
	  }

	  @Override
	  public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
	    // no creative items, nono
		

	}


	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (slot == EntityEquipmentSlot.HEAD || slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.FEET) {
			return ServerMod.MOD_ID + ":textures/armor/diamondtechspacesuit_1.png";
		} else if (slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.LEGS) {
			return ServerMod.MOD_ID + ":textures/armor/diamondtechspacesuit_2.png";
		} else {
			return null;
	}
		}
	
													//Equip on Right Click\\
	
		  public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
		    {
		        ItemStack itemstack = playerIn.getHeldItem(handIn);
		        EntityEquipmentSlot entityequipmentslot = EntityLiving.getSlotForItemStack(itemstack);
		        ItemStack itemstack1 = playerIn.getItemStackFromSlot(entityequipmentslot);

		        if (itemstack1.isEmpty())
		        {
		            playerIn.setItemStackToSlot(entityequipmentslot, itemstack.copy());
		            itemstack.setCount(0);
		            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		        }
		        else
		        {
		            return new ActionResult(EnumActionResult.FAIL, itemstack);
		        }
		    
		    }
		  
		  @Override
		  public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		  if (itemStack.getItem().equals(ModItems.DiamondTechSpaceHelmet))
		      player.addPotionEffect(new PotionEffect(Potion.getPotionById(16)));
		  {
			  if (itemStack.getItem().equals(ModItems.DiamondTechSpaceChestplate))
			      player.addPotionEffect(new PotionEffect(Potion.getPotionById(13)));
			  {
					  if (itemStack.getItem().equals(ModItems.DiamondTechSpaceBoots))
					      player.addPotionEffect(new PotionEffect(Potion.getPotionById(8)));
				  }
					
		  }
	 }


				// TODO Auto-generated method stub
		  
		  
																//Anvil Repair\\


		        		public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		        		return repair.getItem() == ModItems.Techite;
		        		
		        		}

		        													//Crafting Recipe\\
		        		

		        		public void addRecipes() {
		        			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.DiamondTechSpaceHelmet), "ITI", "TGT", "ITI", 'T', ModItems.Techite, 'I',
					        		new ItemStack (Items.IRON_INGOT), 'G', new ItemStack (Blocks.STAINED_GLASS_PANE, 1, 9)));		
		        		{
		        			
		        		}
			        		GameRegistry.addShapedRecipe(new ItemStack(ModItems.DiamondTechSpaceChestplate), "I I", "TTT", "ITI", 'T', ModItems.Techite, 'I',
			        				new ItemStack(Items.IRON_INGOT));
		
			        	{
			        			
			        	}
		        			GameRegistry.addShapedRecipe(new ItemStack(ModItems.DiamondTechSpaceLeggings), "LTL", "TLT", "L L", 'T', ModItems.Techite, 'L',
		        					new ItemStack(Items.LEATHER));	
		
			        	{
			        			
			        	}
		        	
		        			GameRegistry.addShapedRecipe(new ItemStack(ModItems.DiamondTechSpaceBoots), "   ", "I I", "T T", 'I', Items.IRON_INGOT, 'T',
		        					new ItemStack(ModItems.Techite));	
		
			        		}
			        		
						}
