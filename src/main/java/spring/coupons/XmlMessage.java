// package spring.coupons;
//
// import java.io.StringReader;
// import java.io.StringWriter;
//
// import javax.xml.bind.JAXB;
// import javax.xml.bind.annotation.XmlRootElement;
//
// @XmlRootElement
// public class XmlMessage {
// private String message;
//
// public XmlMessage() {
// }
//
// public XmlMessage(String message) {
// super();
// this.message = message;
// }
//
// public String getMessage() {
// return message;
// }
//
// public void setMessage(String message) {
// this.message = message;
// }
//
// @Override
// public String toString() {
// return "Message [message=" + message + "]";
// }
//
// public String toXml() {
// StringWriter writer = new StringWriter();
// JAXB.marshal(this, writer);
// return writer.toString();
// }
//
// public static XmlMessage fromXml(String xml) {
// StringReader reader = new StringReader(xml);
// return JAXB.unmarshal(reader, XmlMessage.class);
// }
//
// }
