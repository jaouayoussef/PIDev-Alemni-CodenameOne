package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.services.serviceUser;
import java.util.Vector;

/**
 * SignUp UI
 *
 * @author louay
 */
public class SignUpForm extends BaseForm {

    public SignUpForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
        TextField firstName = new TextField("", "First name");
        TextField lastName = new TextField("", "Last name");
        TextField picture = new TextField("", "picture");
        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        TextField confirmPassword = new TextField("", "Confirm Password", 20, TextField.PASSWORD);

        Vector<String> vectorRole;
        vectorRole = new Vector();
        vectorRole.add("Client");
        vectorRole.add("Tutor");

        ComboBox<String> roles;
        roles = new ComboBox<>(vectorRole);

        Vector<String> vecGender;
        vecGender = new Vector();
        vecGender.add("Male");
        vecGender.add("Female");

        ComboBox<String> gender;
        gender = new ComboBox<>(vecGender);

        email.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        confirmPassword.setSingleLineTextArea(false);
        Button next = new Button("create account");
        Button signIn = new Button("Sign In");


        signIn.addActionListener(e -> new SignInForm(res).show());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");

        Container content = BoxLayout.encloseY(
                new Label("Sign Up", "LogoLabel"),
                createLineSeparator(),
                new FloatingHint(firstName),
                createLineSeparator(),
                new FloatingHint(lastName),
                createLineSeparator(),
                new FloatingHint(picture),
                createLineSeparator(),
                new FloatingHint(email),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                new FloatingHint(confirmPassword),
                createLineSeparator(),
                roles,
                createLineSeparator(),
                gender
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
        next.requestFocus();
        next.addActionListener((e) -> {
            serviceUser.getInstance().SignUp(firstName, lastName, email, password, confirmPassword, picture, roles, gender, res);
            Dialog.show("Success", "Welcome to alemni", "OK", null);
            new SignInForm(res).show();
        });
    }

}
