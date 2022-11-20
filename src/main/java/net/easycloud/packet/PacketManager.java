package net.easycloud.packet;


import net.easycloud.packet.list.HelloPacket;
import net.easycloud.packet.list.PingPacket;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PacketManager {

    private GlobalPacketListener globalPacketListener;

    private List<Class<? extends Packet>> packetList = new CopyOnWriteArrayList<>();

    public PacketManager() {
        this.registerPacket(HelloPacket.class);
        this.registerPacket(PingPacket.class);
    }

    public void registerPacket(Class<? extends Packet> packet) {
        packetList.add(packet);
    }

    public int getPacketId(Class<? extends Packet> packet) {
        return packetList.indexOf(packet);
    }

    public boolean existsPacketById(int id) {
        return getPacketById(id) != null;
    }


    public Class<? extends Packet> getPacketById(int packetId) {
        return packetList.get(packetId);
    }

    public void processPacket(Packet packet) {
        System.out.println("processing packet " + packet.getClass().getSimpleName());
        if (globalPacketListener != null) {
            globalPacketListener.listen(packet);
        }
    }

    public void setGlobalPacketListener(GlobalPacketListener globalPacketListener) {
        this.globalPacketListener = globalPacketListener;
    }
}
