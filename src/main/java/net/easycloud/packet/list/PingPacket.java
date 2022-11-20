package net.easycloud.packet.list;

public class PingPacket extends JsonPacket<Long> {

    public PingPacket() {
    }

    public PingPacket(long time) {
        super(time);
    }
}
