package fonnymunkey.portaldupebegone;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = PortalDupeBegone.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void dimensionChangeEvent(EntityTravelToDimensionEvent event) {
        if(event.getEntity().world.isRemote) return;
        if(event.getEntity() instanceof EntityLiving && !(event.getEntity() instanceof EntityPlayer)) {
            EntityLiving entity = (EntityLiving)event.getEntity();
            if(entity.isDead || !entity.isEntityAlive() || entity.getHealth() <= 0) {
                event.setCanceled(true);
                if(ModConfig.server.logPossibleAttemptedDupe) PortalDupeBegone.logger.log(Level.WARN, "Possible attempted dupe at X: " + entity.posX + " Y: " + entity.posY + " Z: " + entity.posZ + " Entity Name: " + entity.getName());
            }
        }
    }
}
