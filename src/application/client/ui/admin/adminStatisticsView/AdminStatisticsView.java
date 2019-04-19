package application.client.ui.admin.adminStatisticsView;

// https://www.mkyong.com/java/java-display-double-in-2-decimal-points/

import application.shared.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

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

    @UiField
    HTMLPanel item2_1;
    @UiField
    HTMLPanel item2_2;
    @UiField
    HTMLPanel item2_3;
    @UiField
    HTMLPanel item2_4;
    @UiField
    HTMLPanel item2_5;
    @UiField
    HTMLPanel item2_6;
    @UiField
    HTMLPanel item2_7;

    @UiField
    HTMLPanel item3_1;
    @UiField
    HTMLPanel item3_2;
    @UiField
    HTMLPanel item3_3;
    @UiField
    HTMLPanel item3_4;
    @UiField
    HTMLPanel item3_5;
    @UiField
    HTMLPanel item3_6;
    @UiField
    HTMLPanel item3_7;

    @UiField
    HTMLPanel item4_1;
    @UiField
    HTMLPanel item4_2;
    @UiField
    HTMLPanel item4_3;
    @UiField
    HTMLPanel item4_4;
    @UiField
    HTMLPanel item4_5;
    @UiField
    HTMLPanel item4_6;
    @UiField
    HTMLPanel item4_7;


    @UiField
    Label totalMembers;
    @UiField
    Label averageAge;
    @UiField
    Label totalBronzeMembers;
    @UiField
    Label averageBronzeAge;
    @UiField
    Label totalSiverMembers;
    @UiField
    Label averageSilverAge;
    @UiField
    Label totalGoldMembers;
    @UiField
    Label averageGoldAge;

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
            i2_1 = 0,
            i2_2 = 0,
            i2_3 = 0,
            i2_4 = 0,
            i2_5 = 0,
            i2_6 = 0,
            i2_7 = 0,
            i3_1 = 0,
            i3_2 = 0,
            i3_3 = 0,
            i3_4 = 0,
            i3_5 = 0,
            i3_6 = 0,
            i3_7 = 0,
            i4_1 = 0,
            i4_2 = 0,
            i4_3 = 0,
            i4_4 = 0,
            i4_5 = 0,
            i4_6 = 0,
            i4_7 = 0,
            // Gets number of total users
            totalUsers = users.size(),
            totalBMembers = 0,
            totalSMembers = 0,
            totalGMembers = 0;

        double avgAge = 0,
                avgBronzeAge = 0,
                avgSilverAge = 0,
                avgGoldAge = 0;

        totalMembers.getElement().setInnerText("Samlet antal medlemmer: " + totalUsers);

        for (User user : users) {
            
            int age = user.getAge();
            // Checks if user is not admin
            
            if (user.getMembertypeId() != 4) {
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
                avgAge += age;
            }

            // Bronze members
            if (user.getMembertypeId() == 3) {
                if (age >= 15 && age < 20) {
                    i2_1+=1;
                } else if (age >= 20 && age < 30) {
                    i2_2+=1;
                } else if (age >= 30 && age < 40) {
                    i2_3+=1;
                } else if (age >= 40 && age < 50) {
                    i2_4+=1;
                } else if (age >= 50 && age < 60) {
                    i2_5+=1;
                } else if (age >= 60 && age < 70) {
                    i2_6+=1;
                } else {
                    i2_7+=1;
                }
                totalBMembers++;
                avgBronzeAge+=age;
            }

            // Silver members
            if (user.getMembertypeId() == 2) {
                if (age >= 15 && age < 20) {
                    i3_1+=1;
                } else if (age >= 20 && age < 30) {
                    i3_2+=1;
                } else if (age >= 30 && age < 40) {
                    i3_3+=1;
                } else if (age >= 40 && age < 50) {
                    i3_4+=1;
                } else if (age >= 50 && age < 60) {
                    i3_5+=1;
                } else if (age >= 60 && age < 70) {
                    i3_6+=1;
                } else {
                    i3_7+=1;
                }
                totalSMembers++;
                avgSilverAge+=age;
            }

            // Silver members
            if (user.getMembertypeId() == 1) {
                if (age >= 15 && age < 20) {
                    i4_1+=1;
                } else if (age >= 20 && age < 30) {
                    i4_2+=1;
                } else if (age >= 30 && age < 40) {
                    i4_3+=1;
                } else if (age >= 40 && age < 50) {
                    i4_4+=1;
                } else if (age >= 50 && age < 60) {
                    i4_5+=1;
                } else if (age >= 60 && age < 70) {
                    i4_6+=1;
                } else {
                    i4_7+=1;
                }
                totalGMembers++;
                avgGoldAge+=age;
            }

        }

        averageAge.getElement().setInnerText("Den gennemsnitlige alder er: " + Math.round(avgAge / totalUsers));
        averageBronzeAge.getElement().setInnerText("Den gennemsnitlige alder er: " + Math.round(avgBronzeAge / totalBMembers));
        averageSilverAge.getElement().setInnerText("Den gennemsnitlige alder er: " + Math.round(avgSilverAge / totalSMembers));
        averageGoldAge.getElement().setInnerText("Den gennemsnitlige alder er: " + Math.round(avgGoldAge / totalGMembers));

        totalBronzeMembers.getElement().setInnerText("Samlet antal bronze medlemmer: " + totalBMembers);
        totalSiverMembers.getElement().setInnerText("Samlet antal bronze medlemmer: " + totalSMembers);
        totalGoldMembers.getElement().setInnerText("Samlet antal bronze medlemmer: " + totalGMembers);

        i1_1 = (i1_1 * 100) / totalUsers;
        i1_2 = (i1_2 * 100) / totalUsers;
        i1_3 = (i1_3 * 100) / totalUsers;
        i1_4 = (i1_4 * 100) / totalUsers;
        i1_5 = (i1_5 * 100) / totalUsers;
        i1_6 = (i1_6 * 100) / totalUsers;
        i1_7 = (i1_7 * 100) / totalUsers;

        i2_1 = (i2_1 * 100) / totalBMembers;
        i2_2 = (i2_2 * 100) / totalBMembers;
        i2_3 = (i2_3 * 100) / totalBMembers;
        i2_4 = (i2_4 * 100) / totalBMembers;
        i2_5 = (i2_5 * 100) / totalBMembers;
        i2_6 = (i2_6 * 100) / totalBMembers;
        i2_7 = (i2_7 * 100) / totalBMembers;

        i3_1 = (i3_1 * 100) / totalSMembers;
        i3_2 = (i3_2 * 100) / totalSMembers;
        i3_3 = (i3_3 * 100) / totalSMembers;
        i3_4 = (i3_4 * 100) / totalSMembers;
        i3_5 = (i3_5 * 100) / totalSMembers;
        i3_6 = (i3_6 * 100) / totalSMembers;
        i3_7 = (i3_7 * 100) / totalSMembers;

        i4_1 = (i4_1 * 100) / totalGMembers;
        i4_2 = (i4_2 * 100) / totalGMembers;
        i4_3 = (i4_3 * 100) / totalGMembers;
        i4_4 = (i4_4 * 100) / totalGMembers;
        i4_5 = (i4_5 * 100) / totalGMembers;
        i4_6 = (i4_6 * 100) / totalGMembers;
        i4_7 = (i4_7 * 100) / totalGMembers;

        item1_1.getElement().setAttribute("style", "width:" + (i1_1 * 2) + "%");
        item1_1.getElement().setInnerText(i1_1 + "%");
        item1_2.getElement().setAttribute("style", "width:" + (i1_2 * 2) + "%");
        item1_2.getElement().setInnerText(i1_2 + "%");
        item1_3.getElement().setAttribute("style", "width:" + (i1_3 * 2) + "%");
        item1_3.getElement().setInnerText(i1_3 + "%");
        item1_4.getElement().setAttribute("style", "width:" + (i1_4 * 2) + "%");
        item1_4.getElement().setInnerText(i1_4 + "%");
        item1_5.getElement().setAttribute("style", "width:" + (i1_5 * 2) + "%");
        item1_5.getElement().setInnerText(i1_5 + "%");
        item1_6.getElement().setAttribute("style", "width:" + (i1_6 * 2) + "%");
        item1_6.getElement().setInnerText(i1_6 + "%");
        item1_7.getElement().setAttribute("style", "width:" + (i1_7  * 2) + "%");
        item1_7.getElement().setInnerText(i1_7 + "%");

        item2_1.getElement().setAttribute("style", "width:" + (i2_1 * 2) + "%");
        item2_1.getElement().setInnerText(i2_1 + "%");
        item2_2.getElement().setAttribute("style", "width:" + (i2_2 * 2) + "%");
        item2_2.getElement().setInnerText(i2_2 + "%");
        item2_3.getElement().setAttribute("style", "width:" + (i2_3 * 2) + "%");
        item2_3.getElement().setInnerText(i2_3 + "%");
        item2_4.getElement().setAttribute("style", "width:" + (i2_4 * 2) + "%");
        item2_4.getElement().setInnerText(i2_4 + "%");
        item2_5.getElement().setAttribute("style", "width:" + (i2_5 * 2) + "%");
        item2_5.getElement().setInnerText(i2_5 + "%");
        item2_6.getElement().setAttribute("style", "width:" + (i2_6 * 2) + "%");
        item2_6.getElement().setInnerText(i2_6 + "%");
        item2_7.getElement().setAttribute("style", "width:" + (i2_7  * 2) + "%");
        item2_7.getElement().setInnerText(i2_7 + "%");

        item3_1.getElement().setAttribute("style", "width:" + (i3_1 * 2) + "%");
        item3_1.getElement().setInnerText(i3_1 + "%");
        item3_2.getElement().setAttribute("style", "width:" + (i3_2 * 2) + "%");
        item3_2.getElement().setInnerText(i3_2 + "%");
        item3_3.getElement().setAttribute("style", "width:" + (i3_3 * 2) + "%");
        item3_3.getElement().setInnerText(i3_3 + "%");
        item3_4.getElement().setAttribute("style", "width:" + (i3_4 * 2) + "%");
        item3_4.getElement().setInnerText(i3_4 + "%");
        item3_5.getElement().setAttribute("style", "width:" + (i3_5 * 2) + "%");
        item3_5.getElement().setInnerText(i3_5 + "%");
        item3_6.getElement().setAttribute("style", "width:" + (i3_6 * 2) + "%");
        item3_6.getElement().setInnerText(i3_6 + "%");
        item3_7.getElement().setAttribute("style", "width:" + (i3_7  * 2) + "%");
        item3_7.getElement().setInnerText(i3_7 + "%");

        item4_1.getElement().setAttribute("style", "width:" + (i4_1 * 2) + "%");
        item4_1.getElement().setInnerText(i4_1 + "%");
        item4_2.getElement().setAttribute("style", "width:" + (i4_2 * 2) + "%");
        item4_2.getElement().setInnerText(i4_2 + "%");
        item4_3.getElement().setAttribute("style", "width:" + (i4_3 * 2) + "%");
        item4_3.getElement().setInnerText(i4_3 + "%");
        item4_4.getElement().setAttribute("style", "width:" + (i4_4 * 2) + "%");
        item4_4.getElement().setInnerText(i4_4 + "%");
        item4_5.getElement().setAttribute("style", "width:" + (i4_5 * 2) + "%");
        item4_5.getElement().setInnerText(i4_5 + "%");
        item4_6.getElement().setAttribute("style", "width:" + (i4_6 * 2) + "%");
        item4_6.getElement().setInnerText(i4_6 + "%");
        item4_7.getElement().setAttribute("style", "width:" + (i4_7  * 2) + "%");
        item4_7.getElement().setInnerText(i4_7 + "%");

    }
}