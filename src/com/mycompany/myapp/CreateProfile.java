/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.util.Vector;
import services.userService;

/**
 *
 * @author louay
 */
public class CreateProfile extends Form {

    public CreateProfile(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("Login");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome, ", "WelcomeWhite"),
                new Label("Create your account", "WelcomeBlue")
        );

        getTitleArea().setUIID("Container");

        TextField firstName = new TextField("", "First name");
        TextField lastName = new TextField("", "Last name");
        TextField picture = new TextField("", "picture");
        TextField email = new TextField("", "email", 20, TextField.ANY);
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

        firstName.getAllStyles().setMargin(LEFT, 0);
        lastName.getAllStyles().setMargin(LEFT, 0);
        picture.getAllStyles().setMargin(LEFT, 0);
        email.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        confirmPassword.getAllStyles().setMargin(LEFT, 0);

        Label firstNameIcon = new Label("", "TextField");
        Label lastNameIcon = new Label("", "TextField");
        Label pictureIcon = new Label("", "TextField");
        Label emailIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        Label confirmPasswordIcon = new Label("", "TextField");

        firstNameIcon.getAllStyles().setMargin(RIGHT, 0);
        lastNameIcon.getAllStyles().setMargin(RIGHT, 0);
        pictureIcon.getAllStyles().setMargin(RIGHT, 0);
        emailIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        confirmPasswordIcon.getAllStyles().setMargin(RIGHT, 0);

        FontImage.setMaterialIcon(firstNameIcon, FontImage.MATERIAL_PERSON, 3);
        FontImage.setMaterialIcon(lastNameIcon, FontImage.MATERIAL_PERSON, 3);
        FontImage.setMaterialIcon(pictureIcon, FontImage.MATERIAL_PICTURE_IN_PICTURE, 3);
        FontImage.setMaterialIcon(emailIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(confirmPasswordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);

        Button createAccount = new Button("Create Account");
        createAccount.setUIID("LoginButton");
        createAccount.addActionListener((l) -> {
            userService.getInstance().SignUp(firstName, lastName, email, password, confirmPassword, picture, roles, gender, theme);
            if (userService.getInstance().SignUp(firstName, lastName, email, password, confirmPassword, picture, roles, gender, theme)) {
                Dialog.show("Success", "Welcome", "OK", null);
                new Login(theme).show();
            }
        });

        Button login = new Button("LOGIN");
        login.addActionListener((l) -> {
            new Login(theme).show();
        });
        login.setUIID("CreateNewAccountButton");

        Label spaceLabel;
        if (!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }

        Container by = BoxLayout.encloseY(
                welcome,
                spaceLabel,
                BorderLayout.center(firstName).
                        add(BorderLayout.WEST, firstNameIcon),
                BorderLayout.center(lastName).
                        add(BorderLayout.WEST, lastNameIcon),
                BorderLayout.center(picture).
                        add(BorderLayout.WEST, pictureIcon),
                BorderLayout.center(email).
                        add(BorderLayout.WEST, emailIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                BorderLayout.center(confirmPassword).
                        add(BorderLayout.WEST, confirmPasswordIcon),
                BorderLayout.center(roles),
                BorderLayout.center(gender),
                createAccount,
                login
        );
        add(BorderLayout.CENTER, by);

        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
