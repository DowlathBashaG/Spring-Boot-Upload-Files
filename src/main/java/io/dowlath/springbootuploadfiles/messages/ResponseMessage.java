package io.dowlath.springbootuploadfiles.messages;

/**
 * @Author Dowlath
 * @create 7/14/2020 11:18 AM
 */
public class ResponseMessage {
    public String message;

    public ResponseMessage(String s){
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
