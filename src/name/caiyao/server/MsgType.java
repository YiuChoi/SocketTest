package name.caiyao.server;

/**
 * Created by 蔡小木 on 2016/7/18 0018.
 */
public enum MsgType {
    EMGW_LOGIN_REQ((byte) 0x00),
    EMGW_LOGIN_RES((byte) 0x01);

    private byte value;

    public byte getValue() {
        return value;
    }

    private MsgType(byte value) {
        this.value = value;
    }
}
