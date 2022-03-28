/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

/**
 *
 * @author louay
 */
public class ProfileHome extends Form {

    Form current;

    public ProfileHome() {
        current = this;
        setTitle("Alemni");
        setLayout(BoxLayout.y());
        getToolbar().addCommandToSideMenu("MyProfile", null, ev -> {
            new ProfileHome().show();
        });
        getToolbar().addCommandToSideMenu("Propriétaire code promo", null, ev -> {
            new PromoCodeOwnerHome().show();
        });
        getToolbar().addCommandToSideMenu("Domaine", null, ev -> {
            new DomaineHome().show();
        });
        getToolbar().addCommandToSideMenu("Quiz", null, ev -> {
            new quizHome().show();
        });

        Button btshow = new Button("Show profile");
        btshow.getStyle().setBgColor(0xffffff);
        btshow.getStyle().setFgColor(0x0080FF);
        btshow.getStyle().setBgTransparency(255);
        btshow.getStyle().setBorder(Border.createRoundBorder(30, 30));
        btshow.getStyle().setPadding(1, 1, 1, 1);
        btshow.getStyle().setMargin(2, 2, 2, 2);

        btshow.addActionListener((e) -> {
            new UserProfile(current).show();
        });
        Form hi = new Form("Profile", new BoxLayout(BoxLayout.Y_AXIS));
        hi.add(btshow);
        Container pub = BoxLayout.encloseY(
                //  BorderLayout.centerAbsolute(
                //      BoxLayout.encloseY(
                //           image
                //   )
                // ),//.add(BorderLayout.WEST, pubImage),
                BoxLayout.encloseY(hi)
        );
        pub.getStyle().setFgColor(0xffffff);
        pub.getStyle().setBgColor(0xCFE2F3);
        pub.getStyle().setBgTransparency(255);
        pub.getStyle().setPadding(7, 7, 7, 7);
        pub.getStyle().setMargin(20, 20, 30, 30);
        pub.getStyle().setBorder(Border.createRoundBorder(50, 50));
        add(pub);

    }

}
