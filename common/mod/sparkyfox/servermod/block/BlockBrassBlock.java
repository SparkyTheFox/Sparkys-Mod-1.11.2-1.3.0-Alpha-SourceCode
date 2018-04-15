package mod.sparkyfox.servermod.block;

import mod.sparkyfox.servermod.ServerMod;
import mod.sparkyfox.servermod.init.ModItems;
import mod.sparkyfox.servermod.lib.ModNames;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;



public class BlockBrassBlock extends Block {

	
	@Override
	public String getUnlocalizedName() {
		return "BrassBlock" + ServerMod.RESOURCE_PREFIX + ModNames.BrassBlock;  // BrassBlock.ServerMod:BrassBlock
	}
	


	public BlockBrassBlock() {							  	  	  //===================================================================================================================//
		super(Material.IRON);					  			 	 // The Material determines some properties of the block.															  //
		this.setHardness(5.0f); 				 				// The hardness determines how long a block takes to break. 5 is a bit high, most are around 2-3.					 //
		this.setResistance(20.0F);     					   	   // Resistance to explosions.																							//
		this.setSoundType(SoundType.METAL);   			  	  // Sound type effects placing, breaking, and step sounds.														   	   //
    	this.setHarvestLevel("pickaxe", 2);   			 	 // This method can be used to set a specific tool type and harvest level. Remove if you don't need any restrictions. //
    	this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);	//===================================================================================================================// 

	}
	
																		//Crafting Recipe//


		public void addRecipes() {
		
				
				GameRegistry.addShapedRecipe(new ItemStack(this),"BBB", "BBB", "BBB", 'B', ModItems.BrassIngot);
				
					
		}
}
