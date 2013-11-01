package mattparks.mods.starcraft.uranus;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.starcraft.uranus.dimension.GCUranusTeleportType;
import mattparks.mods.starcraft.uranus.dimension.GCUranusWorldProvider;
import mattparks.mods.starcraft.uranus.network.GCUranusPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.GCCoreBlocks;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityAlienVillager;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySpider;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityZombie;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreOverworldGenerator;
import micdoodle8.mods.galacticraft.moon.items.GCMoonItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = GCUranus.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCUranus.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCUranus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCUranus
{
    public static final String NAME = "Starcraft Uranus";
    public static final String MODID = "GCUranus";
    public static final String CHANNEL = "GCUranus";
    public static final String CHANNELENTITIES = "GCUranusEntities";

    public static final String LANGUAGE_PATH = "/assets/starcrafturanus/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.starcraft.uranus.client.ClientProxyUranus", serverSide = "mattparks.mods.starcraft.uranus.CommonProxyUranus")
    public static CommonProxyUranus proxy;

    @Instance(GCUranus.MODID)
    public static GCUranus instance;

    public static final String TEXTURE_DOMAIN = "starcrafturanus";
    public static final String TEXTURE_PREFIX = GCUranus.TEXTURE_DOMAIN + ":";
    
    public static long tick;
    public static long slowTick;
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCUranusConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/uranus.conf"));

//        GCVenusBlocks.initBlocks();
//        GCVenusBlocks.setHarvestLevels();

        GCUranus.proxy.preInit(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCUranus.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCUranus.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCUranus.LANGUAGE_PATH + language + ".lang", child, false);
                            languages++;
                        }
                    }
                }
                catch (Exception e)
                {
                    FMLLog.severe("Failed to load a child language file.");
                    e.printStackTrace();
                }
            }

            languages++;
        }

        GCLog.info("Starcraft Uranus Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCUranus.instance, GCUranus.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCUranus.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCUranusWorldProvider.class, new GCUranusTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCUranusPlanet());
        GalacticraftRegistry.registerRocketGui(GCUranusWorldProvider.class, new ResourceLocation(GCUranus.TEXTURE_DOMAIN, "textures/gui/saturnRocketGui.png"));

//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 3), new ItemStack(GCCoreItems.heavyPlatingTier1), new ItemStack(GCMoonItems.meteoricIronIngot, 1, 1));
//        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryRedGemOre, 5, 24, 0, 75, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(MercuryBlocks.MercuryDirt, 5, 24, 0, 75, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryCoalOre, 7, 18, 0, 45, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryTinOre, 8, 3, 0, 25, 7));
//        GameRegistry.registerWorldGenerator(new GCCoreOverworldGenerator(PlutoBlocks.MercuryCopperOre, 8, 3, 0, 25, 7));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCUranusPacketHandlerServer(), GCUranus.CHANNEL, Side.SERVER);
    }

    public void registerTileEntities()
    {
    }

    public void registerCreatures()
    {
    }

    public void registerOtherEntities()
    {
    }
    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCUranus.proxy.postInit(event);
        GCUranus.proxy.registerRenderInformation();
//        GCSaturnRecipeManager.loadRecipes();
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCUranus.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
}
