package mod.sparkyfox.servermod.item.tools;

import java.util.Set;

import com.google.common.collect.Sets;

import mod.sparkyfox.servermod.ServerMod;
import mod.sparkyfox.servermod.init.ModItems;
import mod.sparkyfox.servermod.lib.ModNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemLapisAxe extends ItemTool {

	  private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});
	    private static final float[] ATTACK_DAMAGES = new float[] {6.0F, 8.0F, 8.0F, 8.0F, 6.0F};//{6.0F, 8.0F, 8.0F, 8.0F, 6.0F};
	    private static final float[] ATTACK_SPEEDS = new float[] { -3.2F, -3.2F, -3.1F, -3.0F, -3.0F};//{ -3.2F, -3.2F, -3.1F, -3.0F, -3.0F};

	    public ItemLapisAxe(ToolMaterial material, String unlocalizedName)
	    {
	        super(material, EFFECTIVE_ON);
	        this.setCreativeTab(CreativeTabs.TOOLS);
	    }

	    public ItemLapisAxe(Item.ToolMaterial material, float damage, float speed)
	    {
	        super(material, EFFECTIVE_ON);
	        this.damageVsEntity = damage;
	        this.attackSpeed = speed;
	    }

	    public float getStrVsBlock(ItemStack stack, IBlockState state)
	    {
	        Material material = state.getMaterial();
	        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	    }
	
    
    
	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "LapisAxe" + ServerMod.RESOURCE_PREFIX + ModNames.LapisAxe;
	}
	

																								//Anvil Repair\\


	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {

		 return repair.getItem() == ModItems.TitaniumHammer;
	}

																							//Crafting Recipe//


	public void addRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this), "LL ", "LS ", " S ", 'L', "dyeBlue", 'S',
				new ItemStack(Items.STICK)));
	}
		
	}
    

