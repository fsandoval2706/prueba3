package PruebasUnitarias;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import bean.Usuario;
import mantenimiento.GestionUsuario;
import formularios.LoginForm;

public class GestionUsuarioTest {
	@Test
	public void pruebaObtenerUsuarioExitoso() {
		GestionUsuario gestionUsuario=new GestionUsuario();
		
		Usuario usuario2=new Usuario();
		
		usuario2.setUsername("fsandoval");
		usuario2.setPassword("123456");
		
		
		boolean resultado =true;
		Usuario usu=gestionUsuario.obtenerUsuario(usuario2);
		
		if(usu==null) {
		resultado=false;
		}
	
	
	assertEquals("La obtención del usuario exitosa debe ser verdadera", true, resultado);
}
	
}

