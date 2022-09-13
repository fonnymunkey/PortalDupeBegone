package fonnymunkey.portaldupebegone;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = PortalDupeBegone.MOD_ID)
public class ModConfig {
    @Config.Comment("Server Config")
    @Config.Name("Server")
    public static final ServerConfig server = new ServerConfig();

    public static class ServerConfig {
        @Config.Comment("Log possible attempted dupes with xyz coordinates and entity name. (May cause some log spam when it happens.)")
        @Config.Name("Log Possible Attempts")
        public boolean logPossibleAttemptedDupe = false;
    }

    @Mod.EventBusSubscriber(modid = PortalDupeBegone.MOD_ID)
    private static class EventHandler{
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if(event.getModID().equals(PortalDupeBegone.MOD_ID)) ConfigManager.sync(PortalDupeBegone.MOD_ID, Config.Type.INSTANCE);
        }
    }
}
