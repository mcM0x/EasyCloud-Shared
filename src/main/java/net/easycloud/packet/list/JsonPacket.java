package net.easycloud.packet.list;

import net.easycloud.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

public class JsonPacket<O> implements Packet {

    private O payload;
    private Class<O> payloadClass;

    public JsonPacket() {
        //https://stackoverflow.com/a/17767068
        this.payloadClass = (Class<O>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    public JsonPacket(O payload) {
        this();
        this.payload = payload;
    }

    @Override
    public void write(DataOutputStream outputStream) throws IOException {
        String s = GSON.toJson(payload);
        outputStream.writeUTF(s);
    }

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        String json = inputStream.readUTF();
        payload = (O) GSON.fromJson(json, payloadClass);
    }

    public O getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return GSON.toJson(this.payload);
    }
}
