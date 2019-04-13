package application.client.ui.admin.adminMainView;

import application.client.ui.admin.adminCreateMembersView.AdminCreateMembersView;
import application.client.ui.admin.adminMembersView.AdminMembersView;
import application.client.ui.admin.adminStatisticsView.AdminStatisticsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class AdminMainView extends Composite {
    private static AdminMainViewUiBinder ourUiBinder = GWT.create(AdminMainViewUiBinder.class);

    private AdminMembersView adminMembersView;
    private AdminCreateMembersView adminCreateMembersView;
    private AdminStatisticsView adminStatisticsView;

    @UiField
    Button logOutBtn;

    @UiField
    Button newUserBtn;

    @UiField
    Button membersBtn;

    @UiField
    DeckLayoutPanel contentPanel1;

    public AdminMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        adminMembersView = new AdminMembersView();
        contentPanel1.add(adminMembersView);

        adminCreateMembersView = new AdminCreateMembersView();
        contentPanel1.add(adminCreateMembersView);

        adminStatisticsView = new AdminStatisticsView();
        contentPanel1.add(adminStatisticsView);

        contentPanel1.showWidget(adminStatisticsView);

    }

    interface AdminMainViewUiBinder extends UiBinder<HTMLPanel, AdminMainView> {
    }

    public void addClickHandler(ClickHandler clickHandler) {
        logOutBtn.addClickHandler(clickHandler);
        newUserBtn.addClickHandler(clickHandler);
        membersBtn.addClickHandler(clickHandler);
    }

    public void changeView(Widget panel) {
        contentPanel1.showWidget(panel);
    }

    /**
     *
     * Getter method for the create user button
     *
     * @return
     */
    public Button getNewUserBtn() {
        return newUserBtn;
    }

    public Button getLogOutBtn() {
        return logOutBtn;
    }

    public Button getMembersBtn() {
        return membersBtn;
    }

    public AdminCreateMembersView getAdminCreateMembersView() {
        return adminCreateMembersView;
    }

    public AdminMembersView getAdminMembersView() {
        return adminMembersView;
    }

}