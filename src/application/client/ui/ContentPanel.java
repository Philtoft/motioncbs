package application.client.ui;

import application.client.ui.admin.adminMainView.AdminMainView;
import application.client.ui.create.CreateView;
import application.client.ui.guest.GuestView;
import application.client.ui.login.LoginView;
import application.client.ui.user.userMainView.UserMainView;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ContentPanel extends Composite {

    // Hovedpanelet
    private DeckLayoutPanel contentPanel;

    private GuestView guestView;
    private LoginView loginView;
    private UserMainView userMainView;
    private CreateView createView;
    private AdminMainView adminMainView;

    public ContentPanel() {

        contentPanel = new DeckLayoutPanel();

        guestView = new GuestView();
        contentPanel.add(guestView);

        loginView = new LoginView();
        contentPanel.add(loginView);

        createView = new CreateView();
        contentPanel.add(createView);

        userMainView = new UserMainView();
        contentPanel.add(userMainView);

        adminMainView = new AdminMainView();
        contentPanel.add(adminMainView);

        //contentPanel.showWidget(guestView);
        contentPanel.showWidget(guestView);

        initWidget(contentPanel);

    }

    public void changeView(Widget panel) {
        contentPanel.showWidget(panel);
    }

    public GuestView getGuestView() {
        return guestView;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public UserMainView getUserMainView() {
        return userMainView;
    }

    public CreateView getCreateView() {
        return createView;
    }

    public AdminMainView getAdminMainView() {
        return adminMainView;
    }
}
