package net.easycloud.packet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Packet {

    public static Gson GSON = new GsonBuilder().enableComplexMapKeySerialization().create();

    void write(DataOutputStream outputStream) throws IOException;

    void read(DataInputStream inputStream) throws IOException;

}
