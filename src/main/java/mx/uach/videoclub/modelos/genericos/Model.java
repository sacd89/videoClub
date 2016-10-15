package mx.uach.videoclub.modelos.genericos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Modelo general de todo el sistema.
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 */
public class Model {

     public static final String Q_WHERE_ID = "WHERE id = ";

    public static final String Q_WHERE = "WHERE";

    public static final String INSERT = "INSERT INTO";
    
    public static final String UPDATE = "UPDATE";
    
    public static final String DELETE = "DELETE FROM";

    public static final String ID = "id";

    private Integer id;

    /**
     * Constructor vacio.
     */
    public Model() {
    }

    /**
     * Constructor que trae de parametro el id de cualquier modelo.
     * 
     * @param id que es el identificador unico de cualquier modelo.
     */
    public Model(Integer id) {
        this.id = id;
    }

    /**
     * Método que obtiene el id de cualquier modelo.
     * 
     * @return id que es el identificador unico de cualquier modelo.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que asigna un id a cualquier modelo.
     * 
     * @param id que es el identificador unico de cualquier modelo.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Convierte de un arreglo de campos a un String para un query.
     *
     * @param fields son los atributos de la tabla.
     * @param noId si es verdadero excluye el campo id.
     * @return attr1, attr2, ... attrn
     */
    public static String fieldsToQuery(String[] fields, Boolean noId) {
        String campos = "";
        List<String> fieldsList = Arrays.asList(fields);
        fieldsList = noId
                ? fieldsList.stream()
                .filter(field -> !field.equals(ID))
                .collect(Collectors.toList()) : fieldsList;
        for (String field : fieldsList) {
            campos = String.format("%s, %s", campos, field);
        }
        return campos.substring(1);
    }

    /**
     * Crea un string de ? separados por comas, igual a la cantidad
     * de campos que tiene el modelo.
     * 
     * @param fields que es un arreglo con los nombres de los campos del modelo.
     * @param noId que es si requiere o no el id dentro del string.
     * @return ?,?,?,....,?
     */
    public static String paramsToStatement(String[] fields, Boolean noId) {
        String campos = "";
        List<String> fieldsList = Arrays.asList(fields);
        fieldsList = noId
                ? fieldsList.stream()
                .filter(field -> !field.equals(ID))
                .collect(Collectors.toList()) : fieldsList;
        for (String field : fieldsList) {
            campos = String.format("%s, ?", campos);
        }
        return campos.substring(1);
    }
    
    /**
     * Crea un string del nombrecampo = ? separados por comas, igual a la cantidad
     * de campos que tiene el modelo.
     * 
     * @param fields que es el arreglo con los nombres de los campos del modelo.
     * @param noId que es si requiere o no el id dentro del string
     * @return nombre = ?,nombre = ?,...,nombre = ?
     */
    public static String paramsToStatementToCreate(String[] fields, Boolean noId) {
        String campos = "";
        List<String> fieldsList = Arrays.asList(fields);
        fieldsList = noId
                ? fieldsList.stream()
                .filter(field -> !field.equals(ID))
                .collect(Collectors.toList()) : fieldsList;
        for (String field : fieldsList) {
            campos = String.format("%s, %s = ?", campos, field);
        }
        return campos.substring(1);
    }
}
