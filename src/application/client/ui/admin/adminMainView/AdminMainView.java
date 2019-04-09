package application.client.ui.admin.adminMainView;

import application.client.ui.admin.adminCreateMembersView.AdminCreateMembersView;
import application.client.ui.admin.adminMembersView.AdminMembersView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class AdminMainView extends Composite {
    private static AdminMainViewUiBinder ourUiBinder = GWT.create(AdminMainViewUiBinder.class);

    private AdminMembersView adminMembersView;
    private AdminCreateMembersView adminCreateMembersView;

    @UiField
    Label logOut;

    @UiField
    Button newUser;

    @UiField
    DeckLayoutPanel contentPanel1;

    public AdminMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        adminMembersView = new AdminMembersView();
        contentPanel1.add(adminMembersView);

        adminCreateMembersView = new AdminCreateMembersView();
        contentPanel1.add(adminCreateMembersView);

        contentPanel1.showWidget(adminMembersView);

    }

    interface AdminMainViewUiBinder extends UiBinder<HTMLPanel, AdminMainView> {
    }

    public AdminMembersView getAdminMembersView() {
        return adminMembersView;
    }

    /**
     *
     * Getter method for the create user button
     *
     * @return
     */
    public Button getNewUser() {
        return newUser;
    }

    public AdminCreateMembersView getAdminCreateMembersView() {
        return adminCreateMembersView;
    }
}