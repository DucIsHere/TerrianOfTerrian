package com.jjthunder.terrathunder_overworld;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod("terrathunder_overworld")
public class TerrathunderOverworldMain {
   public static final String MODID = "terrathunder_overworld";
   private static final Logger LOGGER = LogUtils.getLogger();
   public static final DeferredRegister<Block> BLOCKS;
   public static final DeferredRegister<Item> ITEMS;
   public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS;
   public static final RegistryObject<Block> EXAMPLE_BLOCK;
   public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM;
   public static final RegistryObject<Item> EXAMPLE_ITEM;
   public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB;

   public TerrathunderOverworldMain() {
      IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
      modEventBus.addListener(this::commonSetup);
      BLOCKS.register(modEventBus);
      ITEMS.register(modEventBus);
      CREATIVE_MODE_TABS.register(modEventBus);
      MinecraftForge.EVENT_BUS.register(this);
      modEventBus.addListener(this::addCreative);
      ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC);
   }

   private void commonSetup(FMLCommonSetupEvent event) {
      LOGGER.info("HELLO FROM COMMON SETUP");
      if (Config.logDirtBlock) {
         LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.f_50493_));
      }

      LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
      Config.items.forEach((item) -> {
         LOGGER.info("ITEM >> {}", item.toString());
      });
   }

   private void addCreative(BuildCreativeModeTabContentsEvent event) {
      if (event.getTabKey() == CreativeModeTabs.f_256788_) {
         event.accept(EXAMPLE_BLOCK_ITEM);
      }

   }

   @SubscribeEvent
   public void onServerStarting(ServerStartingEvent event) {
      LOGGER.info("HELLO from server starting");
   }

   static {
      BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "terrathunder_overworld");
      ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "terrathunder_overworld");
      CREATIVE_MODE_TABS = DeferredRegister.create(Registries.f_279569_, "terrathunder_overworld");
      EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> {
         return new Block(Properties.m_284310_().m_284180_(MapColor.f_283947_));
      });
      EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> {
         return new BlockItem((Block)EXAMPLE_BLOCK.get(), new net.minecraft.world.item.Item.Properties());
      });
      EXAMPLE_ITEM = ITEMS.register("example_item", () -> {
         return new Item((new net.minecraft.world.item.Item.Properties()).m_41489_((new Builder()).m_38765_().m_38760_(1).m_38758_(2.0F).m_38767_()));
      });
      EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> {
         return CreativeModeTab.builder().withTabsBefore(new ResourceKey[]{CreativeModeTabs.f_256797_}).m_257737_(() -> {
            return ((Item)EXAMPLE_ITEM.get()).m_7968_();
         }).m_257501_((parameters, output) -> {
            output.m_246326_((ItemLike)EXAMPLE_ITEM.get());
         }).m_257652_();
      });
   }

   @EventBusSubscriber(
      modid = "terrathunder_overworld",
      bus = Bus.MOD,
      value = {Dist.CLIENT}
   )
   public static class ClientModEvents {
      @SubscribeEvent
      public static void onClientSetup(FMLClientSetupEvent event) {
         TerrathunderOverworldMain.LOGGER.info("HELLO FROM CLIENT SETUP");
         TerrathunderOverworldMain.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.m_91087_().m_91094_().m_92546_());
      }
   }
}
