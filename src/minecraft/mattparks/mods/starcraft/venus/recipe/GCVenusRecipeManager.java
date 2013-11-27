package mattparks.mods.starcraft.venus.recipe;

import java.util.HashMap;

import mattparks.mods.starcraft.venus.util.GCVenusUtil;
import mattparks.mods.starcraft.core.StarcraftCore;
import mattparks.mods.starcraft.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCVenusRecipeManager
{
    public static void loadRecipes()
    {
        GCVenusRecipeManager.addUniversalRecipes();
    }

    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("ingotGem", new ItemStack(GCVenusItems.venusItemBasic, 1, 1));
        OreDictionary.registerOre("plateGem", new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    	
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 1), new Object[] { "X", "X", 'X', "plateGem" });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemBoots), new Object[] { "X X", "X X", 'X', "plateGem" });
        
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemHelmet), new Object[] { "XXX", "X X", 'X', "plateGem" });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "plateGem" });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "plateGem" });
        
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemSword), new Object[] { "X", "X", "Y", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "plateGem", 'Y',Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemSpade), new Object[] { "X", "Y", "Y", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemHoe), new Object[] { "XX", "Y ", "Y ", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemHoe), new Object[] { "XX", " Y", " Y", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemAxe), new Object[] { "XX", "XY", " Y", 'X', "plateGem", 'Y', Item.stick  });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemAxe), new Object[] { "XX", "YX", "Y ", 'X', "plateGem", 'Y', Item.stick });
        
        OreDictionary.registerOre("ingotSulfer", new ItemStack(GCVenusItems.venusItemBasic, 1, 0));
        OreDictionary.registerOre("plateSulfer", new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
        
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferBoots), new Object[] { "X X", "X X", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferSword), new Object[] { "X", "X", "Y", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferSpade), new Object[] { "X", "Y", "Y", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferHoe), new Object[] { "XX", "Y ", "Y ", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferHoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferAxe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferAxe), new Object[] { "XX", "YX", "Y ", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 'Y', Item.stick });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferHelmet), new Object[] { "XXX", "X X", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferChestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0) });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulferLeggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(GCVenusItems.venusItemBasic, 1, 0) });

        
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusBattery, 1, GCVenusItems.venusBattery.getMaxDamage()), new Object[] { " T ", "TRT", "TCT", 'T', "plateSulfer", 'R', Item.redstone, 'C', Item.coal });
        
        
        RecipeUtil.addRecipe(new ItemStack(StarcraftCore.VenusSulferBlock, 1, 0), new Object[] { "TTT", "TTT", "TTT", 'T', "ingotSulfer",});
        
        RecipeUtil.addRecipe(new ItemStack(StarcraftCore.VenusRedGemBlock, 1, 0), new Object[] { "TTT", "TTT", "TTT", 'T', new ItemStack(GCVenusItems.venusItemBasic, 1, 0)});
        
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new Object[] { "WXW", "WYW", "WZW", 'X', "compressedSteel", 'Y', Block.glass, 'Z', new ItemStack(GCCoreItems.canister, 1, 0), 'W', "plateSulfer" });
        
        GameRegistry.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 0), new ItemStack(StarcraftCore.VenusSulferBlock, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 0), new ItemStack(StarcraftCore.VenusRedGemBlock, 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 4), new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftCore.VenusBasalt, 1, 0),  new ItemStack(GCVenusItems.venusItemBasic, 1, 7), new ItemStack(GCVenusItems.venusItemBasic, 1, 7), new ItemStack(GCVenusItems.venusItemBasic, 1, 7), new ItemStack(GCVenusItems.venusItemBasic, 1, 7));
        
        GameRegistry.addShapelessRecipe(new ItemStack(StarcraftCore.VenusHalfBasalt, 6, 0), new ItemStack(StarcraftCore.VenusBasalt, 1, 0), new ItemStack(StarcraftCore.VenusBasalt, 1, 0), new ItemStack(StarcraftCore.VenusBasalt, 1, 0));
        
        
        // Compressor recipes
        
        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 2), "ingotSulfer", "ingotSulfer");
        
        CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 1), new ItemStack(GCVenusItems.venusItemBasic, 1, 2), new ItemStack(GCVenusItems.venusItemBasic, 1, 2) );
         CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 2), "ingotGem", "ingotGem");
        
        // Smelting
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.MercuryCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.MercuryCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.MercuryTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);        
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.VenusSulferOre.blockID, 0, new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.VenusCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.VenusIronOre.blockID, 0, new ItemStack(Item.ingotIron), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.VenusCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.VenusTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(StarcraftCore.VenusRedGemOre.blockID, 0, new ItemStack(GCVenusItems.venusItemBasic, 1, 0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenusItems.venusItemBasic.itemID, 6, new ItemStack(GCVenusItems.venusItemBasic, 1, 7), 0.2F);
    
        // Schematic
        HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
        input.put(1, new ItemStack(GCCoreItems.partNoseCone));
        input.put(2, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(3, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(4, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(5, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(6, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(7, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(8, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(9, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(10, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(11, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(12, new ItemStack(GCCoreItems.rocketEngine, 1, 1));
        input.put(13, new ItemStack(GCCoreItems.partFins));
        input.put(14, new ItemStack(GCCoreItems.partFins));
        input.put(15, new ItemStack(GCCoreItems.rocketEngine));
        input.put(16, new ItemStack(GCCoreItems.rocketEngine, 1, 1));
        input.put(17, new ItemStack(GCCoreItems.partFins));
        input.put(18, new ItemStack(GCCoreItems.partFins));
        input.put(19, null);
        input.put(20, null);
        input.put(21, null);
        GCVenusUtil.addRocketBenchT3Recipe(new ItemStack(GCVenusItems.spaceshipT3, 1, 0), input);

        HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, null);
        input2.put(21, null);
        GCVenusUtil.addRocketBenchT3Recipe(new ItemStack(GCVenusItems.spaceshipT3, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, null);
        GCVenusUtil.addRocketBenchT3Recipe(new ItemStack(GCVenusItems.spaceshipT3, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, null);
        input2.put(21, new ItemStack(Block.chest));
        GCVenusUtil.addRocketBenchT3Recipe(new ItemStack(GCVenusItems.spaceshipT3, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, null);
        GCVenusUtil.addRocketBenchT3Recipe(new ItemStack(GCVenusItems.spaceshipT3, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, null);
        input2.put(21, new ItemStack(Block.chest));
        GCVenusUtil.addRocketBenchT3Recipe(new ItemStack(GCVenusItems.spaceshipT3, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, new ItemStack(Block.chest));
        GCVenusUtil.addRocketBenchT3Recipe(new ItemStack(GCVenusItems.spaceshipT3, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack(Block.chest));
        input2.put(20, new ItemStack(Block.chest));
        input2.put(21, new ItemStack(Block.chest));
        GCVenusUtil.addRocketBenchT3Recipe(new ItemStack(GCVenusItems.spaceshipT3, 1, 3), input2);
        
        //
        
        input = new HashMap<Integer, ItemStack>();
        input.put(1, new ItemStack(GCCoreItems.partNoseCone));
        input.put(2, new ItemStack(GCCoreItems.basicItem, 1, 14));
        input.put(3, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(4, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(5, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(6, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(7, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(8, new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
        input.put(9, new ItemStack(GCCoreItems.partFins));
        input.put(10, new ItemStack(GCCoreItems.partFins));
        input.put(11, new ItemStack(GCCoreItems.rocketEngine));
        input.put(12, new ItemStack(GCCoreItems.partFins));
        input.put(13, new ItemStack(GCCoreItems.partFins));

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(14, new ItemStack(Block.chest));
        input2.put(15, null);
        input2.put(16, null);
    }
}
