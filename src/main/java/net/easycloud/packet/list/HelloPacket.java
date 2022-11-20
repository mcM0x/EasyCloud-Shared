package net.easycloud.packet.list;

public class HelloPacket extends JsonPacket<String> {

    public HelloPacket() {
    }

    public HelloPacket(String payload) {
        super(payload);
    }
}
