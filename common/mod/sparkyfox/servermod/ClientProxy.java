package mod.sparkyfox.servermod;

import mod.sparkyfox.servermod.init.ModEntities;
import mod.sparkyfox.servermod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy {

	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		ModItems.initClient(Minecraft.getMinecraft().getRenderItem().getItemModelMesher());
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		
	}

	public void registerModels() {
    ModEntities.initModels();
	ModEntities.init();
    
	}
}