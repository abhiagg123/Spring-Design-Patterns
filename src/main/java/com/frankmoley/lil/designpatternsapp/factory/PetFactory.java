package com.frankmoley.lil.designpatternsapp.factory;

import org.springframework.stereotype.Component;

@Component
public class PetFactory {
    public Pet createPet(String type){
        switch(type){
            case "Dog":
                return new Dog();
            case "Cat":
                return new Cat();
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }
}
