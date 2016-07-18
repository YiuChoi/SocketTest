package name.caiyao.server.Mina;

/**
 * Created by 蔡小木 on 2016/7/18 0018.
 */
public class Msg {
    private MsgHeader msgHeader = new MsgHeader();
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Msg() {
    }

    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }

}
