package name.caiyao.server.Mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * Created by 蔡小木 on 2016/6/30 0030.
 */
public class CustomTextLineDecoder implements ProtocolDecoder {

    @Override
    public void decode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        int startPosition = ioBuffer.position();
        while (ioBuffer.hasRemaining()){
            byte b = ioBuffer.get();
            if (b == '\n'){
                int currentPosition = ioBuffer.position();
                int limit = ioBuffer.limit();
                ioBuffer.position(startPosition);
                ioBuffer.limit(currentPosition);
                IoBuffer ioBuffer1 = ioBuffer.slice();
                byte[] dest = new byte[ioBuffer1.limit()];
                ioBuffer1.get(dest);
                String str = new String(dest);
                protocolDecoderOutput.write(str);
                ioBuffer.position(currentPosition);
                ioBuffer.limit(limit);
            }
        }
    }

    @Override
    public void finishDecode(IoSession ioSession, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {

    }

    @Override
    public void dispose(IoSession ioSession) throws Exception {

    }
}
