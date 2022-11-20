package net.easycloud.packet;


import java.net.Socket;

public interface GlobalPacketListener {

    void listen(Socket socket, Packet p);


}
