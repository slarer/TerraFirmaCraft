package net.dries007.tfc.world.classic;

import net.dries007.tfc.Constants;

public class WorldGenSettings
{
    public final int spawnFuzz;
    public final boolean flatBedrock;
    public final int ravineRarity;
    public final int ravineHeight;
    public final int ravineVariability;
    public final int surfaceRavineRarity;
    public final int surfaceRavineHeight;
    public final int surfaceRavineVariability;
    public final int riverRavineRarity;

    public WorldGenSettings(WorldGenSettingsBuilder b)
    {
        spawnFuzz = b.spawnFuzz;
        flatBedrock = b.flatBedrock;
        ravineRarity = b.ravineRarity;
        ravineHeight = b.ravineHeight;
        ravineVariability = b.ravineVariability;
        surfaceRavineRarity = b.surfaceRavineRarity;
        surfaceRavineHeight = b.surfaceRavineHeight;
        surfaceRavineVariability = b.surfaceRavineVariability;
        riverRavineRarity = b.riverRavineRarity;
    }

    public static class WorldGenSettingsBuilder
    {
        public int spawnFuzz = 250;
        public boolean flatBedrock = false;

        public int ravineRarity = 100;
        public int ravineHeight = 20;
        public int ravineVariability = 50;

        public int surfaceRavineRarity = 100;
        public int surfaceRavineHeight = 125;
        public int surfaceRavineVariability = 30;

        public int riverRavineRarity = 400;

        public boolean isDefault()
        {
            return spawnFuzz == 250 &&
                    !flatBedrock &&
                    ravineRarity == 100 &&
                    ravineHeight == 20 &&
                    ravineVariability == 50 &&
                    surfaceRavineRarity == 100 &&
                    surfaceRavineHeight == 125 &&
                    surfaceRavineVariability == 30 &&
                    riverRavineRarity == 400;
        }

        public WorldGenSettings build()
        {
            return new WorldGenSettings(this);
        }

        @Override
        public String toString()
        {
            return Constants.GSON.toJson(this);
        }
    }

    public static WorldGenSettingsBuilder fromString(String options)
    {
        return Constants.GSON.fromJson(options, WorldGenSettingsBuilder.class);
    }

    @Override
    public String toString()
    {
        return Constants.GSON.toJson(this);
    }
}