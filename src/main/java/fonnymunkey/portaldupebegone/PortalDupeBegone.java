package fonnymunkey.portaldupebegone;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = PortalDupeBegone.MOD_ID,
        name = PortalDupeBegone.MOD_NAME,
        version = PortalDupeBegone.VERSION,
        acceptableRemoteVersions = "*"
)
public class PortalDupeBegone {
    public static final String MOD_ID = "portaldupebegone";
    public static final String MOD_NAME = "PortalDupeBegone";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MOD_ID)
    public static PortalDupeBegone INSTANCE;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }
}
