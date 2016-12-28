package LN;

/**
 * @author javier.cerro
 * Interfaz para la independencia entre la LN y la LP.
 */
public interface itfProperty 
{
	
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo String.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return devuelve el nombre de la propiedad
	 */
	String 	getStringProperty	(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo Integer.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return devuelve el nombre de la propiedad
	 */
	Integer getIntegerProperty	(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo Float.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return devuelve el nombre de la propiedad
	 */
	Float 	getFloatProperty	(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo Double.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return devuelve el nombre de la propiedad
	 */
	Double	getDoubleProperty	(String propiedad);
	
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo char.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return devuelve el nombre de la propiedad
	 */
	char	getCharProperty		(String propiedad);
	/**
	 * Devuelve la propiedad solicitada por nombre de tipo boolean.
	 * @param propiedad nombre de la propiedad a devolver del objeto. 
	 * @return devuelve el nombre de la propiedad
	 */
	boolean getBooleanProperty (String propiedad);

}