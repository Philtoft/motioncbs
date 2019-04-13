package application.client.ui.admin.adminStatisticsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class AdminStatisticsView extends Composite {
    interface AdminStatisticsViewUiBinder extends UiBinder<HTMLPanel, AdminStatisticsView> {
    }

    private static AdminStatisticsViewUiBinder ourUiBinder = GWT.create(AdminStatisticsViewUiBinder.class);

    public AdminStatisticsView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}