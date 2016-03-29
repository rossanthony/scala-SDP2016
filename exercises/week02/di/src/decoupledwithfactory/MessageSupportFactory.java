package decoupledwithfactory;

import java.io.FileInputStream;
import java.util.Properties;

public class MessageSupportFactory {

    private static MessageSupportFactory instance = null;

    static {
        instance = new MessageSupportFactory();
    }

    private Properties props = null;
    private MessageRenderer renderer = null;
    private MessageProvider provider = null;

    private MessageSupportFactory() {
        props = new Properties();

        try {
            props.load(new FileInputStream("/Users/keith/Courses/sdp/2016/SDP2016/di/src/decoupledwithfactory/bean.properties"));

            // get the implementation classes
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(rendererClass)
                    .newInstance();
            provider = (MessageProvider) Class.forName(providerClass)
                    .newInstance();
        } catch (Exception ex) {
            System.err.println("Failed to create factory methods");
            ex.printStackTrace();
        }
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }

}