package application.client.ui.admin.adminMainView;

import application.client.ui.admin.adminMembersView.AdminMembersView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class AdminMainView extends Composite {
    private static AdminMainViewUiBinder ourUiBinder = GWT.create(AdminMainViewUiBinder.class);

    private AdminMembersView adminMembersView;

    @UiField
    Label logOut;

    @UiField
    DeckLayoutPanel contentPanel1;

    public AdminMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        adminMembersView = new AdminMembersView();
        contentPanel1.add(adminMembersView);

        contentPanel1.showWidget(adminMembersView);

    }

    interface AdminMainViewUiBinder extends UiBinder<HTMLPanel, AdminMainView> {
    }

    public AdminMembersView getAdminMembersView() {
        return adminMembersView;
    }
}