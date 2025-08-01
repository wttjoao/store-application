package com.joaoalves.storeapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        // SpringApplication.run(StoreApplication.class, args);
        /**
         * var user = User.builder()
         *                 .name("Joao")
         *                 .password("pass")
         *                 .email("joaoalves1102@outlook.pt")
         *                 .build();
         *
         *         var address = Address.builder()
         *                 .city("Porto")
         *                 .state("Porto")
         *                 .zip("4700")
         *                 .street("Rua")
         *                 .build();
         *
         *         var profile = Profile.builder()
         *                 .bio("bio1")
         *                 .build();
         *
         *         user.setProfile(profile);
         *         profile.setUser(user);
         *         user.addTag("tag1");
         *         user.addAddress(address);
         *
         *         System.out.println(user);
         */
        var category = Category.builder()
                .name("Java")
                .build();

        var product = Product.builder()
                .price(10.00)
                .name("Frango")
                .build();

        category.getProducts().add(product);
        product.setCategory(category);

        System.out.println(category);
    }

}
