package com.collinriggs.avionics.blocks;

@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface TileEntity {
    String tileName();
    Class<? extends net.minecraft.tileentity.TileEntity> tileClass();
}
