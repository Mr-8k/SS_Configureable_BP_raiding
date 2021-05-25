package data.scripts.plugins;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.listeners.ListenerManagerAPI;
import com.fs.starfarer.api.impl.campaign.graid.StandardGroundRaidObjectivesCreator;
import com.fs.starfarer.api.impl.campaign.graid.StandardGroundRaidObjectivesCreatorMOD;


public class BPRAIDPLUGIN extends BaseModPlugin
{
    @Override
    public void onGameLoad(boolean newGame) {


        SectorAPI sector = Global.getSector();

        ListenerManagerAPI listeners = sector.getListenerManager();
        if (listeners.hasListenerOfClass(StandardGroundRaidObjectivesCreator.class)){
            listeners.removeListenerOfClass(StandardGroundRaidObjectivesCreator.class);
        }
        if (!listeners.hasListenerOfClass(StandardGroundRaidObjectivesCreatorMOD.class)) {
            listeners.addListener(new StandardGroundRaidObjectivesCreatorMOD(), true);
        }

    }
}
