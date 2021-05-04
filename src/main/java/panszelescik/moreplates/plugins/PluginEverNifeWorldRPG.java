package panszelescik.moreplates.plugins;

import panszelescik.moreplates.plugins.core.Plugin;
import panszelescik.moreplates.plugins.helpers.PluginHelper;

import static panszelescik.moreplates.plugins.core.ItemInfo.*;

@Plugin(modid = PluginEverNifeWorldRPG.MODID, modname = PluginEverNifeWorldRPG.MODNAME)
public class PluginEverNifeWorldRPG extends PluginHelper {

    public static final String MODID = "evernifeworldrpg";
    public static final String MODNAME = "EverNife's World RPG";

    @Plugin.PreInit
    public static void preInit() {
        reg(SAKURADITE);
        reg(ENEUTRONIUM);
    }

    @Plugin.PostInit
    public static void postInit() {
        add(SAKURADITE);
        add(ENEUTRONIUM);
    }
}