package org.iesvdm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AlturaAlumnoTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    void verdadero() {
        assertTrue(1==1);
    }


    @Test
    void aniadeNombreTest1() {


        final String[] array = new String[2];

        array[0]="Jose";
        array[1]="Paco";

        String nombre = "María";
        String[] arrayActual = AlturaAlumno
                .añadeNombre(array, nombre);

        assertTrue(arrayActual[arrayActual.length-1]
                    .equals(nombre) );

        for (int i = 0; i< array.length;i++)
            assertEquals(array[i], arrayActual[i]);

//        String[] arrayExpected = Arrays.copyOf(array, array.length+1);
//        arrayExpected[arrayExpected.length-1]=nombre;
//
//        assertArrayEquals(arrayExpected, arrayActual);

    }

    @Test
    void aniadeNombreTest2() {


        final String[] array = new String[0];
        int longInicial = array.length;

        String nombre = "María";
        String[] arrayActual = AlturaAlumno
                .añadeNombre(array, nombre);

//        assertTrue(arrayActual[arrayActual.length-1]
//                .equals(nombre) );
        assertEquals(longInicial+1, arrayActual.length);
        assertEquals(nombre, arrayActual[longInicial+1]);

    }

    @Test
    void modificaAlturaPosicionEnElArray() {

        //When (Cuando)
        double[] array = {1.6, 1.8, 1.7};
        double[] array2 = Arrays.copyOf(array,array.length);
        int posicion = 1;
        double altura = 1.9;


        //Do (Hacer)
        AlturaAlumno.modificaAltura(array, posicion, altura);


        //Then (Entonces)

        //altura esta en la posicion
        assertTrue( altura == array[posicion]);

        //Todos los demas elementos del array no cambian
        for (int i = 0; i < array.length; i++) {
            if (i != posicion) {
                assertEquals(array[i], array2[i]);
            }
        }

    }

    @Test
    void modificaAlturaPosicionFueraDeRangoArray() {

        //When (Cuando)
        double[] array = {1.6, 1.8, 1.7};
        double[] array2 = Arrays.copyOf(array,array.length);
        int posicion = array.length+2;
        double altura = 1.9;


        //Do (Hacer)
        AlturaAlumno.modificaAltura(array, posicion, altura);


        //Then (Entonces)

        //altura esta en la posicion
        //assertTrue( altura == array[posicion]);

        //Todos los demas elementos del array no cambian
//        for (int i = 0; i < array.length; i++) {
//                assertEquals(array[i], array2[i]);
//        }
        assertArrayEquals(array2, array);

    }

    @Test
    void buscarNombre(){

        /*given : */
        // Aquí definimos las variables que hay en el método.
        String[] array = { "hola","juan"};
        String nombre = "juan";
        int position = 1;

        /*when : */
        // Definimos un result para el Test, que es del mismo tipo que la variable
        // que se retorna en el método;
        int result = AlturaAlumno.buscaNombre(array, nombre);

        /*then : */
        assertEquals(nombre, array[1]);

    }

    @Test void mostrar (){
        //given //
        String[]arrayNombre = {"Juan", "bela"};
        double[]arrayAltura = {1.3,1.5};

        AlturaAlumno.mostrar(arrayNombre, arrayAltura);
        assertEquals("Juan\t|   1.3\nbela\t|   1.5\n", outputStreamCaptor.toString());
        assertTrue(outputStreamCaptor.toString().contains("Juan"));
    }
    }
