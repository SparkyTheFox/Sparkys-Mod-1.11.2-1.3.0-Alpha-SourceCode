package mod.sparkyfox.servermod;

import mod.sparkyfox.servermod.entity.EntityAK4URounds;
//import mod.sparkyfox.servermod.entity.EntityFlowey;
//import mod.sparkyfox.servermod.entity.EntityFriendlynessPellet;
import mod.sparkyfox.servermod.entity.EntitySMGRounds;
import mod.sparkyfox.servermod.init.ModBlocks;
import mod.sparkyfox.servermod.init.ModItems;
import mod.sparkyfox.servermod.init.ModProps;
import mod.sparkyfox.servermod.init.ModSlab;
import mod.sparkyfox.servermod.init.ModStairs;
import mod.sparkyfox.servermod.render.RenderAK4URounds;
//import mod.sparkyfox.servermod.render.RenderFlowey;
//import mod.sparkyfox.servermod.render.RenderFriendlynessPellet;
import mod.sparkyfox.servermod.render.RenderSMGRounds;
import mod.sparkyfox.servermod.world.WorldGenOre;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ClientProxy extends CommonProxy {
	
//===========================================================================================================================================================================================\\	
																					//Bright Sparks Model Registry\\
	
    public static void regModel(Item item)
    {
        if(item instanceof ISubTypes && item.getHasSubtypes())
            for(int meta = 0; meta < ((ISubTypes) item).getSubNames().length; meta++)
                ModelLoader.setCustomModelResourceLocation(item, meta,
                        new ModelResourceLocation(item.getRegistryName().toString() + "/" + ((ISubTypes) item).getSubNames()[meta], "inventory"));
        else
            regModel(item, 0);
    }

    public static void regModel(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        assert item != null : "Block has no Item!";
        if(block instanceof ISubTypes)
            for(int meta = 0; meta < ((ISubTypes) block).getSubNames().length; meta++)
                ModelLoader.setCustomModelResourceLocation(item, meta,
                        new ModelResourceLocation(item.getRegistryName().toString() + "/" + ((ISubTypes) block).getSubNames()[meta], "inventory"));
        else
            regModel(item);
    }

    public static void regModel(Item item, int meta)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

	
//===========================================================================================================================================================================================\\	
																								//Model Registry\\
	
	public void registerModels() {
		
		//Bullets and Ammo
		registerModel(ModItems.SMGRounds, 0);
		registerModel(ModItems.AK4URounds, 0);
	}
	
																								
//===============================================================================================================================================================================================\\
																								//Render Registry\\
	
	public void registerRenderer() {
	
																									//Ammo\\
	//SMG Rounds	
	RenderingRegistry.registerEntityRenderingHandler(EntitySMGRounds.class, new IRenderFactory() {
		@Override
		public Render createRenderFor(RenderManager manager) {
			return new RenderSMGRounds(manager);
		}});
	
	//AK-4U Rounds	
	RenderingRegistry.registerEntityRenderingHandler(EntityAK4URounds.class, new IRenderFactory() {
		@Override
		public Render createRenderFor(RenderManager manager) {
			return new RenderAK4URounds(manager);
		}});
	
	/**
	 Flowey
	 
    RenderingRegistry.registerEntityRenderingHandler(EntityFlowey.class, new IRenderFactory() {
    	@Override
		public Render createRenderFor(RenderManager manager) {
			return new RenderFlowey(manager, null, 0);
    	}});
    
  //Friendlyness Pellet	
  	RenderingRegistry.registerEntityRenderingHandler(EntityFriendlynessPellet.class, new IRenderFactory() {
  		@Override
  		public Render createRenderFor(RenderManager manager) {
  			return new RenderFriendlynessPellet(manager);
  		}});
  	
	*/		
//===============================================================================================================================================================================================\\
																								//Event Handler\\
	
	}
	public void registerEventHandler() {
	}
	
//===============================================================================================================================================================================================\\
																								//Register Model?\\
	
	private void registerModel(Object obj, int meta) {

		Item item;
		if (obj instanceof Item) {
			item = (Item) obj;
		} else if (obj instanceof Block) {
			item = Item.getItemFromBlock((Block) obj);
		} else {
			throw new IllegalArgumentException("Only item and block instances");
		}
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
//===============================================================================================================================================================================================\\
																										//Inits\\
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		 //new BookLoader();
		
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		ModItems.initClient(mesher);
		ModBlocks.initClient(mesher);
		GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);  //Register the ore generatorY
		//RegistryHandler.client();
		
	}

	/**
	 * Registers the renders
	 */
	@Override
	public void registerRenders() {
		ModSlab.registerRenders();
		ModStairs.registerRenders();
		ModProps.registerRenders();

	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
//===============================================================================================================================================================================================\\
   
    
	}
