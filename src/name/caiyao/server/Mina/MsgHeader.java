package name.caiyao.server.Mina;

/**
 * Created by 蔡小木 on 2016/7/18 0018.
 */
public class MsgHeader {
    private byte magic;    // 魔数
    private byte msgType;    // 消息类型
    private short reserve;    // 保留字
    private short sn;        // 序列号
    private int len;        // 长度

    public byte getMagic() {
        return magic;
    }

    public void setMagic(byte magic) {
        this.magic = magic;
    }

    public byte getMsgType() {
        return msgType;
    }

    public void setMsgType(byte msgType) {
        this.msgType = msgType;
    }

    public short getReserve() {
        return reserve;
    }

    public void setReserve(short reserve) {
        this.reserve = reserve;
    }

    public short getSn() {
        return sn;
    }

    public void setSn(short sn) {
        this.sn = sn;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public MsgHeader() {
    }

    public MsgHeader(byte magic, byte msgType, short reserve, short sn, int len) {
        this.magic = magic;
        this.msgType = msgType;
        this.reserve = reserve;
        this.sn = sn;
        this.len = len;
    }
}
