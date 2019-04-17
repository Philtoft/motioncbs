package application.client.ui.admin.adminStatisticsView;

import application.shared.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.view.client.ListDataProvider;

import java.util.ArrayList;

public class AdminStatisticsView extends Composite {
    interface AdminStatisticsViewUiBinder extends UiBinder<HTMLPanel, AdminStatisticsView> {
    }

    @UiField
    HTMLPanel item1_1;
    @UiField
    HTMLPanel item1_2;
    @UiField
    HTMLPanel item1_3;
    @UiField
    HTMLPanel item1_4;
    @UiField
    HTMLPanel item1_5;
    @UiField
    HTMLPanel item1_6;
    @UiField
    HTMLPanel item1_7;

    private static AdminStatisticsViewUiBinder ourUiBinder = GWT.create(AdminStatisticsViewUiBinder.class);

    public AdminStatisticsView() {
        initWidget(ourUiBinder.createAndBindUi(this));

    }

    public void statistics(ArrayList<User> users){

        int i1_1 = 0,
            i1_2 = 0,
            i1_3 = 0,
            i1_4 = 0,
            i1_5 = 0,
            i1_6 = 0,
            i1_7 = 0,
            // Gets number of total users
            totalUsers = users.size();

        for (User user : users) {
            // Checks if user is not admin
            if (user.getMembertypeId() != 4) {
                int age = user.getAge();
                if (age >= 15 && age < 20) {
                    i1_1+=1;
                } else if (age >= 20 && age < 30) {
                    i1_2+=1;
                } else if (age >= 30 && age < 40) {
                    i1_3+=1;
                } else if (age >= 40 && age < 50) {
                    i1_4+=1;
                } else if (age >= 50 && age < 60) {
                    i1_5+=1;
                } else if (age >= 60 && age < 70) {
                    i1_6+=1;
                } else {
                    i1_7+=1;
                }
            }
        }

        i1_1 = (i1_1 * 100) / totalUsers;
        i1_2 = (i1_2 * 100) / totalUsers;
        i1_3 = (i1_3 * 100) / totalUsers;
        i1_4 = (i1_4 * 100) / totalUsers;
        i1_5 = (i1_5 * 100) / totalUsers;
        i1_6 = (i1_6 * 100) / totalUsers;
        i1_7 = (i1_7 * 100) / totalUsers;

        item1_1.getElement().setAttribute("style", "width:" + i1_1 + "%");
        item1_1.getElement().setInnerText(i1_1 + "%");
        item1_2.getElement().setAttribute("style", "width:" + i1_2 + "%");
        item1_2.getElement().setInnerText(i1_2 + "%");
        item1_3.getElement().setAttribute("style", "width:" + i1_3 + "%");
        item1_3.getElement().setInnerText(i1_3 + "%");
        item1_4.getElement().setAttribute("style", "width:" + i1_4 + "%");
        item1_4.getElement().setInnerText(i1_4 + "%");
        item1_5.getElement().setAttribute("style", "width:" + i1_5 + "%");
        item1_5.getElement().setInnerText(i1_5 + "%");
        item1_6.getElement().setAttribute("style", "width:" + i1_6 + "%");
        item1_6.getElement().setInnerText(i1_6 + "%");
        item1_7.getElement().setAttribute("style", "width:" + i1_7 + "%");
        item1_7.getElement().setInnerText(i1_7 + "%");

    }
}