package com.jjthunder.terrathunder_overworld;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(
   modid = "terrathunder_overworld",
   bus = Bus.MOD
)
public class Config {
   private static final Builder BUILDER = new Builder();
   private static final BooleanValue LOG_DIRT_BLOCK;
   private static final IntValue MAGIC_NUMBER;
   public static final ConfigValue<String> MAGIC_NUMBER_INTRODUCTION;
   private static final ConfigValue<List<? extends String>> ITEM_STRINGS;
   static final ForgeConfigSpec SPEC;
   public static boolean logDirtBlock;
   public static int magicNumber;
   public static String magicNumberIntroduction;
   public static Set<Item> items;

   private static boolean validateItemName(Object obj) {
      boolean var10000;
      if (obj instanceof String) {
         String itemName = (String)obj;
         if (ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName))) {
            var10000 = true;
            return var10000;
         }
      }

      var10000 = false;
      return var10000;
   }

   @SubscribeEvent
   static void onLoad(ModConfigEvent event) {
      logDirtBlock = (Boolean)LOG_DIRT_BLOCK.get();
      magicNumber = (Integer)MAGIC_NUMBER.get();
      magicNumberIntroduction = (String)MAGIC_NUMBER_INTRODUCTION.get();
      items = (Set)((List)ITEM_STRINGS.get()).stream().map((itemName) -> {
         return (Item)ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName));
      }).collect(Collectors.toSet());
   }

   static {
      LOG_DIRT_BLOCK = BUILDER.comment("Whether to log the dirt block on common setup").define("logDirtBlock", true);
      MAGIC_NUMBER = BUILDER.comment("A magic number").defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
      MAGIC_NUMBER_INTRODUCTION = BUILDER.comment("What you want the introduction message to be for the magic number").define("magicNumberIntroduction", "The magic number is... ");
      ITEM_STRINGS = BUILDER.comment("A list of items to log on common setup.").defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);
      SPEC = BUILDER.build();
   }
}
