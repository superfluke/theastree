package fluke.theastree;

import org.apache.logging.log4j.Logger;

import fluke.theastree.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TheasTree.MODID, name = TheasTree.NAME, version = TheasTree.VERSION, dependencies = TheasTree.DEPENDS)
public class TheasTree 
{

	public static final String MODID = "theastree";
	public static final String NAME = "Thea's Tree";
	public static final String VERSION = "1.0.0";
	public static final String DEPENDS = "";

	@Instance(MODID)
	public static TheasTree instance;

	@SidedProxy(clientSide = "fluke.theastree.proxy.ClientProxy", serverSide = "fluke.theastree.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static Logger logger;
	
	public TheasTree()
	{
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
	}
}
