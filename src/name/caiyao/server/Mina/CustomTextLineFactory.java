package name.caiyao.server.Mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * Created by caiya on 2016/6/30 0030.
 */
public class CustomTextLineFactory implements ProtocolCodecFactory {

    private CustomTextLineDecoder customTextLineDecoder;
    private CustomTextLineEncoder customTextLineEncoder;

    public CustomTextLineFactory(){
        customTextLineDecoder = new CustomTextLineDecoder();
        customTextLineEncoder = new CustomTextLineEncoder();
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return customTextLineEncoder;
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return customTextLineDecoder;
    }
}
