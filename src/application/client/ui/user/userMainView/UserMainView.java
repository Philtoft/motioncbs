package application.client.ui.user.userMainView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class UserMainView extends Composite {
    interface userMainViewUiBinder extends UiBinder<HTMLPanel, UserMainView> {
    }

    private static userMainViewUiBinder ourUiBinder = GWT.create(userMainViewUiBinder.class);

    public UserMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}