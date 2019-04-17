package application.client.ui.create;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class CreateView extends Composite {
    interface CreateViewUiBinder extends UiBinder<HTMLPanel, CreateView> {
    }

    private static CreateViewUiBinder ourUiBinder = GWT.create(CreateViewUiBinder.class);

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

    public CreateView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        fname.getElement().setPropertyString("placeholder", "Fornavn");
        lname.getElement().setPropertyString("placeholder", "Efternavn");
        email.getElement().setPropertyString("placeholder", "Email");
        email.getElement().setPropertyString("type", "email");
        password.getElement().setPropertyString("placeholder", "Adgangskode");
        address.getElement().setPropertyString("placeholder", "Post nr");
        address.getElement().setPropertyString("type", "number");
        phoneNumber.getElement().setPropertyString("placeholder", "Tlf.");
        phoneNumber.getElement().setPropertyString("type", "number");
        age.getElement().setPropertyString("placeholder", "Alder");
        age.getElement().setPropertyString("type", "number");

    }

    /**
     *
     * Tilføjer en click handler til knappen, når brugeren skal laves
     *
     * @param clickHandler
     */
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
     * Getters for de forskellige værdier
     *
     * @return
     */
    public RadioButton getGenderFemaleBtn() {
        return genderFemaleBtn;
    }

    public Button getCreateUserBtn() {
        return createUserBtn;
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

    public TextBox getAddress() {
        return address;
    }

    public TextBox getEmail() {
        return email;
    }

    public TextBox getFname() {
        return fname;
    }

    public TextBox getLname() {
        return lname;
    }

    public TextBox getPassword() {
        return password;
    }

    public TextBox getPhoneNumber() {
        return phoneNumber;
    }

    public TextBox getAge() {
        return age;
    }
}