package name.caiyao.server.Mina;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by caiya on 2016/6/30 0030.
 */
public class MinaServer {
    public static void main(String[] args) {
        try {
            NioSocketAcceptor nioSocketAcceptor = new NioSocketAcceptor();
            nioSocketAcceptor.setHandler(new MinaServerHandler());
            nioSocketAcceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,5);
            nioSocketAcceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new CustomTextLineFactory()));
            nioSocketAcceptor.bind(new InetSocketAddress(9898));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
