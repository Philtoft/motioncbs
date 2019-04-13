package application.client.ui.admin.adminCreateMembersView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class AdminCreateMembersView extends Composite {
    interface AdminCreateMembersViewUiBinder extends UiBinder<HTMLPanel, AdminCreateMembersView> {
    }

    private static AdminCreateMembersViewUiBinder ourUiBinder = GWT.create(AdminCreateMembersViewUiBinder.class);

    @UiField
    TextBox fname;
    @UiField
    TextBox lname;
    @UiField
    TextBox email;
    @UiField
    TextBox password;
    @UiField
    TextBox address;
    @UiField
    TextBox age;
    @UiField
    TextBox phoneNumber;
    @UiField
    RadioButton genderMaleBtn;
    @UiField
    RadioButton genderFemaleBtn;
    @UiField
    RadioButton memberGold;
    @UiField
    RadioButton memberSilver;
    @UiField
    RadioButton memberBronze;
    @UiField
    Button createUserBtn;

    public AdminCreateMembersView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        fname.getElement().setPropertyString("placeholder", "Fornavn");
        lname.getElement().setPropertyString("placeholder", "Efternavn");
        email.getElement().setPropertyString("placeholder", "Email");
        email.getElement().setPropertyString("type", "email");
        password.getElement().setPropertyString("placeholder", "Adgangskode");
        address.getElement().setPropertyString("placeholder", "Adresse");
        phoneNumber.getElement().setPropertyString("placeholder", "Tlf.");
        phoneNumber.getElement().setPropertyString("type", "number");
        age.getElement().setPropertyString("placeholder", "Alder");
        age.getElement().setPropertyString("type", "number");
    }

    public void addClickHandler(ClickHandler clickHandler) {
        createUserBtn.addClickHandler(clickHandler);
    }

    public void clearTextboxFields() {
        fname.setText("");
        lname.setText("");
        email.setText("");
        password.setText("");
        address.setText("");
        phoneNumber.setText("");
        age.setText("");
        genderFemaleBtn.setValue(false);
        genderMaleBtn.setValue(false);
        memberBronze.setValue(false);
        memberSilver.setValue(false);
        memberGold.setValue(false);
    }

    /**
     * Getters
     */

    public TextBox getEmail() {
        return email;
    }

    public TextBox getFname() {
        return fname;
    }

    public TextBox getLname() {
        return lname;
    }

    public TextBox getAddress() {
        return address;
    }

    public TextBox getAge() {
        return age;
    }

    public TextBox getPassword() {
        return password;
    }

    public TextBox getPhoneNumber() {
        return phoneNumber;
    }

    public Button getCreateUserBtn() {
        return createUserBtn;
    }

    public RadioButton getGenderFemaleBtn() {
        return genderFemaleBtn;
    }

    public RadioButton getGenderMaleBtn() {
        return genderMaleBtn;
    }

    public RadioButton getMemberBronze() {
        return memberBronze;
    }

    public RadioButton getMemberGold() {
        return memberGold;
    }

    public RadioButton getMemberSilver() {
        return memberSilver;
    }
}