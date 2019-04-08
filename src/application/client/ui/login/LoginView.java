package application.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class LoginView extends Composite {
    interface LoginViewUiBinder extends UiBinder<HTMLPanel, LoginView> {
    }

    @UiField
    Button loginBtn;
    @UiField
    TextBox emailTxtBox;
    @UiField
    PasswordTextBox passwordTxtBox;
    @UiField
    Label forgotPassword;

    private static LoginViewUiBinder ourUiBinder = GWT.create(LoginViewUiBinder.class);

    public LoginView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        emailTxtBox.getElement().setPropertyString("placeholder", "Email");
        passwordTxtBox.getElement().setPropertyString("placeholder", "adgangskode");
    }

    /**
     * Metode, der tilføjer en click handler på login-knappen
     *
     * @param clickHandler
     */
    public void addClickHandlers(ClickHandler clickHandler) {
        loginBtn.addClickHandler(clickHandler);
        forgotPassword.addClickHandler(clickHandler);
    }

    /**
     *
     */
    public void clearTextBoxFields() {
        emailTxtBox.setText("");
        passwordTxtBox.setText("");
    }

    /**
     * Getter metoder
     */

    public Button getLoginBtn() {
        return loginBtn;
    }

    public Label getForgotPassword() {
        return forgotPassword;
    }

    public TextBox getEmailTxtBox() {
        return emailTxtBox;
    }

    public PasswordTextBox getPasswordTxtBox() {
        return passwordTxtBox;
    }
}