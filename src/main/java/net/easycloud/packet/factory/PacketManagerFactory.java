package net.easycloud.packet.factory;


import net.easycloud.packet.PacketManager;

public class PacketManagerFactory {

    public static PacketManager create(){
        return new PacketManager();
    }

}
