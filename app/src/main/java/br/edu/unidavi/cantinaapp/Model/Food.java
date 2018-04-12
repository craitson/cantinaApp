package br.edu.unidavi.cantinaapp.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Craitson on 11/04/2018.
 */

public class Food {

    @Getter
    @Setter
    private int codigo;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private float valor;

    @Getter
    @Setter
    private String photoUrl;


}
