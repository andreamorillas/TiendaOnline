package DATOS;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import COMUN.clsConstantes.enFicDatos;


public interface itfDatos 
{
	
	public void ComenzarSave(enFicDatos fichero);
	
	public void TerminarSave();
	
	public void Save(Serializable o);
	
	public void ComenzarRead(enFicDatos fichero) throws IOException;
	
	public void TerminarRead();
	
	public ArrayList<Serializable> Read();	
	
	public void ResetFile (enFicDatos fichero);
}


