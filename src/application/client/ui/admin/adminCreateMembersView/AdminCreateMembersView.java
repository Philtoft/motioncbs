package application.client.ui.admin.adminCreateMembersView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class AdminCreateMembersView extends Composite {
    interface AdminCreateMembersViewUiBinder extends UiBinder<HTMLPanel, AdminCreateMembersView> {
    }

    private static AdminCreateMembersViewUiBinder ourUiBinder = GWT.create(AdminCreateMembersViewUiBinder.class);

    public AdminCreateMembersView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void addClickHandler() {

    }

}