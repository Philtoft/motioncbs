package application.client.ui.admin.adminMembersView;

import application.shared.User;
import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.view.client.ListDataProvider;

import java.util.Comparator;

public class AdminMembersView extends Composite {
    interface allMembersViewUiBinder extends UiBinder<HTMLPanel, AdminMembersView> {
    }
    private static allMembersViewUiBinder ourUiBinder = GWT.create(allMembersViewUiBinder.class);

    @UiField
    DataGrid<User> dataGrid;

    @UiField
    SimplePager pager;

    private ActionCell.Delegate<User> actionCell;

    public AdminMembersView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        dataGrid.setPageSize(50);

        pager.setDisplay(dataGrid);

        dataGrid.setAutoHeaderRefreshDisabled(true);

    }

    /**
     *
     * Method loaded from the controller so the table can be
     * inserted with data from the db
     *
     * @param dataProvider
     */
    public void initUsersTable(ListDataProvider<User> dataProvider) {

        ColumnSortEvent.ListHandler<User> sortHandler = new ColumnSortEvent.ListHandler<User> (dataProvider.getList());
        dataGrid.addColumnSortHandler(sortHandler);

        initTableColumns(sortHandler);

        dataProvider.addDataDisplay(dataGrid);

    }

    /**
     *
     * Method that creates all the columns.
     *
     * @param sortHandler
     */
    public void initTableColumns (ColumnSortEvent.ListHandler<User> sortHandler) {

        // NAVN
        Column<User, String> nameColumn = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getName();
            }
        };

        nameColumn.setSortable(true);

        sortHandler.setComparator(nameColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getName().compareTo(u2.getName());
            }
        });

        dataGrid.addColumn(nameColumn, "Navn");
        dataGrid.setColumnWidth(nameColumn, 5, Style.Unit.PX);

        // Email
        Column<User, String> emailColumn = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getEmail();
            }
        };

        dataGrid.addColumn(emailColumn, "Email");
        dataGrid.setColumnWidth(emailColumn, 5, Style.Unit.PX);

        // Password
        Column<User, String> passwordColumn = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getPassword();
            }
        };

        dataGrid.addColumn(passwordColumn, "Password");
        dataGrid.setColumnWidth(passwordColumn, 5, Style.Unit.PX);

        // Køn
        Column<User, String> gender = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getGender();
            }
        };

        dataGrid.addColumn(gender, "Køn");
        dataGrid.setColumnWidth(gender, 5, Style.Unit.PX);

        // Adresse
        Column<User, String> address = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getZipCode();
            }
        };

        dataGrid.addColumn(address, "Adresse");
        dataGrid.setColumnWidth(address, 5, Style.Unit.PX);

        // Medlemstype
        Column<User, String> memberType = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                String membertype;
                switch(user.getMembertypeId()) {
                    case 1:
                        membertype = "Guld";
                        break;
                    case 2:
                        membertype = "Sølv";
                        break;
                    case 3:
                        membertype = "Bronze";
                        break;
                    default:
                        membertype = "";
                        break;
                }
                return membertype;
            }
        };

        memberType.setSortable(true);

        sortHandler.setComparator(memberType, new Comparator<User>() {
            public String memberConverter(int membertype) {
                String membertypeString = "";
                switch(membertype) {
                    case 1:
                        membertypeString = "Guld";
                        break;
                    case 2:
                        membertypeString = "Sølv";
                        break;
                    case 3:
                        membertypeString = "Bronze";
                        break;
                }
                return membertypeString;
            }

            @Override
            public int compare(User u1, User u2) {
                return memberConverter(u1.getMembertypeId()).compareTo(memberConverter(u2.getMembertypeId()));
            }
        });

    }

}