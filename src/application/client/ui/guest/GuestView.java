package application.client.ui.guest;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

import java.util.ArrayList;

public class GuestView extends Composite {
    interface GuestViewUiBinder extends UiBinder<HTMLPanel, GuestView> {
    }

    @UiField
    Label toLogin;
    @UiField
    Button signUp1;
    @UiField
    Button signUp2;

    private static GuestViewUiBinder ourUiBinder = GWT.create(GuestViewUiBinder.class);

    public GuestView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void addClickHandlers(ClickHandler clickHandler) {
        toLogin.addClickHandler(clickHandler);
        signUp1.addClickHandler(clickHandler);
        signUp2.addClickHandler(clickHandler);
    }

    public Button getSignUp1() {
        return signUp1;
    }

    public Button getSignUp2() {
        return signUp2;
    }

//    public ArrayList<Button> getSignUp() {
//        ArrayList<Button> signUps = new ArrayList<Button>();
//        signUps.add(signUp1);
//        signUps.add(signUp2);
//        return signUps;
//    }
}