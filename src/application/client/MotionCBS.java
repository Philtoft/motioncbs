package application.client;

import application.client.logic.MainController;
import application.client.rpc.RPCService;
import application.client.rpc.RPCServiceAsync;
import application.client.ui.ContentPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MotionCBS implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        // Instansierer ui
        ContentPanel content = new ContentPanel();
        // Indsætter dem i body
        RootLayoutPanel.get().add(content);
        // Instansierer RPC-servicesen
        RPCServiceAsync rpcService = GWT.create(RPCService.class);
        // Indsætter UI's og forbindelsen i en ny instansiering af MainController
        new MainController(content, rpcService);
    }

}