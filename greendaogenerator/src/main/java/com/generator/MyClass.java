package com.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {
    public static void main(String args) throws Exception {
        Schema schema = new Schema(1, "inf221.trabalho.com.farrago.db");
        Entity comprador = schema.addEntity("Comprador");
        Entity Evento = schema.addEntity("Evento");
        Entity ingresso = schema.addEntity("Inggresso");
        Entity organizador = schema.addEntity("Organizador");
        Entity vendedor = schema.addEntity("Vendedor");

        new DaoGenerator().generateAll(schema, ".app/src/main/java");
    }
}
