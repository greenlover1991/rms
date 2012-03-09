/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package supports;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * To be extended by the controller or view who wants to be updated with transactions
 * Must implement the processBroadCastMessage
 * either to update the the view or etc.
 *
 * sendBroadcast should also be called to notify others in the group
 *
 * extending this class automatically starts the listener thread
 * the class can now send notifications too by the sendNotification method
 * @author squeekyclean
 */
public abstract class NotificationSupport {

    // thread that will listen to map broadcasts
    private Thread mapListeningThread;
    // broadcasting group for same map
    private String mapAddress;
    private InetAddress mapGroup;


    // clients' current map broadcasting socket
    private MulticastSocket mapBroadcastingSocket;

    // byte array buffer for datagrams use
    private byte[] mapBuffer;

    // broadcasting sockets datagram packet
    private DatagramPacket mapBroadcastingPacket;

    // receiving datagram
    private DatagramPacket mapReceivingPacket;

    // multicast socket's port number
    private int portNumber = 1234;

    // max message size in bytes
    private final static int MAX_DATA_SIZE = 8;

    public static enum BROADCAST {NOTIFY_TOM, NOTIFY_CHEF, NOTIFY_ORDER_SLIP};

    public NotificationSupport(){
        try {
            // loaded from db
            mapAddress = "234.234.234.234";
            // initialize broadcasting socket
            mapBroadcastingSocket = new MulticastSocket(portNumber);
            // initiatilize group of same map
            // to be dyanmic through a look-up table or hash
            mapGroup = InetAddress.getByName(mapAddress);
            //initialize buffer
            mapBuffer = new byte[MAX_DATA_SIZE];
            // create the map broadcasting packet
            mapBroadcastingPacket = new DatagramPacket(new byte[MAX_DATA_SIZE], MAX_DATA_SIZE, mapGroup, portNumber);
            // create the receiving for map broadcasts
            mapReceivingPacket = new DatagramPacket(mapBuffer, mapBuffer.length);
            // let the broadcasting socket join a group
            mapBroadcastingSocket.joinGroup(mapGroup);
            mapListeningThread = new Thread() {

                @Override
                public void run() {
                    while (true) {
                        receiveNotifications();
                    }
                }
            };
            mapListeningThread.setPriority(Thread.MIN_PRIORITY);
            mapListeningThread.start();
        } catch (IOException ex) {
            Logger.getLogger(NotificationSupport.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /** Specify which type of broadcast should be sent. */
    public void sendBroadcast(BROADCAST m)
    {
        mapBroadcastingPacket.setData(m.toString().getBytes());
        try {
            mapBroadcastingSocket.send(mapBroadcastingPacket);
        } catch (IOException ex) {
            Logger.getLogger(NotificationSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void receiveNotifications()
    {
        byte[] result = new byte[MAX_DATA_SIZE];
        try {
            mapBroadcastingSocket.receive(mapReceivingPacket);
            result = mapReceivingPacket.getData();
            char[] temp = new char[MAX_DATA_SIZE];
            for (int i = 0; i < result.length; i++)
                temp[i] = ((char)result[i]);
            String str = String.copyValueOf(temp);
            BROADCAST b;
            if(BROADCAST.NOTIFY_CHEF.toString().equals(str))
                b = BROADCAST.NOTIFY_CHEF;
            else if(BROADCAST.NOTIFY_ORDER_SLIP.toString().equals(str))
                b = BROADCAST.NOTIFY_ORDER_SLIP;
            else
                b = BROADCAST.NOTIFY_TOM;
            processBroadcastMessage(b);
        } catch (IOException ex) {
            Logger.getLogger(NotificationSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** Override to process broadcasts. */
    abstract public void processBroadcastMessage(BROADCAST b);
}
