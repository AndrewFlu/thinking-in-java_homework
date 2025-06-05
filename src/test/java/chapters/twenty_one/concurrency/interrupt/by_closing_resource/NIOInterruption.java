package chapters.twenty_one.concurrency.interrupt.by_closing_resource;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NIOInterruption {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8080);
        SocketChannel socketChannel1 = SocketChannel.open(inetSocketAddress);
        SocketChannel socketChannel2 = SocketChannel.open(inetSocketAddress);

        Future<?> future = exec.submit(new NIOBlocked(socketChannel1));
        exec.execute(new NIOBlocked(socketChannel2));
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);

        // прерывание через вызов cancel()
        future.cancel(true);

        TimeUnit.SECONDS.sleep(1);
        // Разблокирование посредством закрытия канала
        socketChannel2.close();

    }
}
