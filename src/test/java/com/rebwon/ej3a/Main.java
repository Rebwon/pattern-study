package com.rebwon.ej3a;

import com.rebwon.ej3a.NyPizza.Builder;
import com.rebwon.ej3a.NyPizza.Size;
import com.rebwon.ej3a.Pizza.Topping;

public final class Main {

    public static void main(String[] args) {
        NyPizza nyPizza = new Builder(Size.SMALL)
            .addTopping(Topping.ONION)
            .addTopping(Topping.SAUSAGE)
            .build();

        Calzone calzone = new Calzone.Builder()
            .addTopping(Topping.HAM)
            .sauceInside()
            .build();
    }
}
