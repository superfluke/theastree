package fluke.dreamtree;

import org.apache.logging.log4j.Logger;

import fluke.dreamtree.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

//TODO oredict for logs/leaves
@Mod(modid = DreamTree.MODID, name = DreamTree.NAME, version = DreamTree.VERSION, dependencies = DreamTree.DEPENDS)
public class DreamTree 
{

	public static final String MODID = "dreamtree";
	public static final String NAME = "Dream Tree";
	public static final String VERSION = "1.1.0";
	public static final String DEPENDS = "";

	@Instance(MODID)
	public static DreamTree instance;

	@SidedProxy(clientSide = "fluke.dreamtree.proxy.ClientProxy", serverSide = "fluke.dreamtree.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static Logger logger;
	
	public DreamTree()
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
